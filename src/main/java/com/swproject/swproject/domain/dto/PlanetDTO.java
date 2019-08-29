package com.swproject.swproject.domain.dto;

import com.google.gson.JsonArray;
import com.swproject.swproject.domain.Planet;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;

public class PlanetDTO implements Serializable {

    private String id;

    @Length(min=2, max=20, message="Name must be between 2 and 20 characters")
    @NotEmpty(message="Field can't be empty")
    private String name;

    @Length(min=2, max=80, message="Name must be between 2 and 80 characters")
    @NotEmpty(message="Field can't be empty")
    private String weather;

    @Length(min=2, max=80, message="Name must be between 2 and 80 characters")
    @NotEmpty(message="Field can't be empty")
    private String terrain;

    ArrayList<String> arrayFilms = new ArrayList<>();

    public PlanetDTO() {
    }

    public PlanetDTO(Planet obj) {
        id = obj.getId();
        name = obj.getName();
        weather = obj.getWeather();
        terrain = obj.getTerrain();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public ArrayList<String> getArrayFilms() {
        return arrayFilms;
    }

    public void setArrayFilms(JsonArray films) {
        for (int i=0; i<films.size(); i++) {
            arrayFilms.add(films.get(i).toString());
        }
    }
}
