package com.swproject.swproject.swapi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.swproject.swproject.domain.dto.PlanetDTO;
import com.swproject.swproject.services.exception.ObjectNotFoundException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArgumentSwitcher {

    private GetRequestRepository repository = new GetRequestRepository();
    private PlanetDTO planet;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void switcher(String command, String searchquery, PlanetDTO objDto) {

        JsonObject jsonObject;

        switch (command) {
            case "films":
                jsonObject = repository.getAll("films", searchquery);
                JsonArray filmresults = jsonObject.getAsJsonArray("results");
                break;
            case "planets":
                planet = objDto;
                jsonObject = repository.getAll("planets", searchquery);
                JsonArray planetresults = jsonObject.getAsJsonArray("results");
                if (planetresults.size() != 0)
                    for (int i = 0; i < planetresults.size(); i++) {
                        JsonObject planetSwapi = planetresults.get(i).getAsJsonObject();
                        JsonArray films = planetSwapi.getAsJsonArray("films");
                        planet.setArrayFilms(films);
                    }
                else {
                    planet.setArrayFilms(new JsonArray());
                }
                break;
            case "starships":
                jsonObject = repository.getAll("starships", searchquery);
                JsonArray starshipresults = jsonObject.getAsJsonArray("results");
                break;
            default:
                System.out.println(command + " is not a available command");
                break;
        }
    }
}
