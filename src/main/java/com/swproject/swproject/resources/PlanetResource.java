package com.swproject.swproject.resources;

import com.swproject.swproject.domain.Planet;
import com.swproject.swproject.domain.dto.PlanetDTO;
import com.swproject.swproject.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/planets")
public class PlanetResource {

    @Autowired
    private PlanetService service;

    @GetMapping
    public ResponseEntity<List<PlanetDTO>> findAll() {
        List<Planet> list = service.findAll();
        List<PlanetDTO> listDTO = list.stream().map(x -> new PlanetDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
