package com.swproject.swproject.controller;

import com.swproject.swproject.domain.Planet;
import com.swproject.swproject.domain.dto.PlanetDTO;
import com.swproject.swproject.resources.util.URL;
import com.swproject.swproject.services.PlanetService;
import com.swproject.swproject.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/planets")
public class PlanetController {

    @Autowired
    private PlanetService service;

    @GetMapping
    public ResponseEntity<List<PlanetDTO>> findAll() {
        List<Planet> list = service.findAll();
        List<PlanetDTO> listDTO = list.stream().map(x -> new PlanetDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<PlanetDTO> findById(@PathVariable String id) {
        Planet obj = service.findById(id);
        return ResponseEntity.ok().body(new PlanetDTO(obj));
    }

    @GetMapping(value="/namesearch")
    public ResponseEntity<List<Planet>> findByName(@RequestParam(value="text", defaultValue="") String text) {
        text = URL.decodeParam(text);
        List<Planet> list = service.findByName(text);
        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(list);
        }
        else {
            throw new ObjectNotFoundException("Object not found");
        }
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody PlanetDTO objDto) {
        Planet obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
