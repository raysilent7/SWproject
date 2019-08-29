package com.swproject.swproject.services;

import com.swproject.swproject.domain.Planet;
import com.swproject.swproject.domain.dto.PlanetDTO;
import com.swproject.swproject.repository.PlanetRepository;
import com.swproject.swproject.services.exception.ObjectNotFoundException;
import com.swproject.swproject.swapi.ArgumentSwitcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository repo;

    public List<Planet> findAll() {
        return repo.findAll();
    }

    public Planet findById(String id) {
        Optional<Planet> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Planet> findByName(String text) {
        return repo.findByName(text);
    }

    public Planet insert(Planet obj) {
        return repo.insert(obj);
    }

    public Planet fromDTO(PlanetDTO objDto) {
        if (objDto.getName() == null || objDto.getName().trim().equals("") ||
                objDto.getWeather() == null || objDto.getWeather().trim().equals("") ||
                objDto.getTerrain() == null || objDto.getTerrain().trim().equals("")) {
            throw new ObjectNotFoundException("Object can't be empty");
        }
        else {
            return new Planet(objDto.getId(), objDto.getName(), objDto.getWeather(), objDto.getTerrain());
        }
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }
}
