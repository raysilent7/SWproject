package com.swproject.swproject.services;

import com.swproject.swproject.domain.Planet;
import com.swproject.swproject.repository.PlanetRepository;
import com.swproject.swproject.services.exceptions.ObjectNotFoundException;
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
}
