package com.swproject.swproject.domain.dto;

import com.swproject.swproject.domain.Planet;

import java.io.Serializable;

public class PlanetDTO implements Serializable {

    private String id;
    private String name;
    private String weather;
    private String terrain;

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
}
