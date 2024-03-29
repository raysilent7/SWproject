package com.swproject.swproject.config;

import com.swproject.swproject.domain.Planet;
import com.swproject.swproject.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class InstantiateData implements CommandLineRunner {

    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public void run(String... args) throws Exception {

        planetRepository.deleteAll();

        Planet pl1 = new Planet(null, "Tatooine", "Arid", "desert");
        Planet pl2 = new Planet(null, "Earth", "Temperate ", "forests, mountains");
        Planet pl3 = new Planet(null, "Pluto", "Cold", "Frozen");
        Planet pl4 = new Planet(null, "Alderaan", "Temperate ", "grasslands, mountains");

        planetRepository.saveAll(Arrays.asList(pl1, pl2, pl3, pl4));
    }
}
