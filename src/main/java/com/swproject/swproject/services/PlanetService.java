package com.swproject.swproject.services;

import com.swproject.swproject.domain.Planet;
import com.swproject.swproject.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository repo;

    public List<Planet> findAll() {
        return repo.findAll();
    }
}
