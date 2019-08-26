package com.swproject.swproject.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document
public class Planet implements Serializable {

    @Id
    private String id;
    private String name;
    private String weather;
    private String terrain;

    public Planet() {
    }

    public Planet(String id, String name, String weather, String terrain) {
        this.id = id;
        this.name = name;
        this.weather = weather;
        this.terrain = terrain;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet)) return false;
        Planet planet = (Planet) o;
        return getId().equals(planet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
