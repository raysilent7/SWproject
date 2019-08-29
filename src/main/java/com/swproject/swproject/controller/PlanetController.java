package com.swproject.swproject.controller;

import com.swproject.swproject.domain.Planet;
import com.swproject.swproject.domain.dto.PlanetDTO;
import com.swproject.swproject.resources.util.URL;
import com.swproject.swproject.services.PlanetService;
import com.swproject.swproject.services.exception.ObjectNotFoundException;
import com.swproject.swproject.swapi.ArgumentSwitcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/planets")
public class PlanetController {

    @Autowired
    private PlanetService service;

    ArgumentSwitcher as = new ArgumentSwitcher();

    @GetMapping
    public ResponseEntity<List<PlanetDTO>> findAll() {
        List<Planet> list = service.findAll();
        List<PlanetDTO> listDTO = list.stream().map(x -> new PlanetDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<PlanetDTO> findById(@PathVariable String id) {
        Planet obj = service.findById(id);
        PlanetDTO objDto = new PlanetDTO(obj);
        as.switcher("planets", objDto.getName(), objDto);
        return ResponseEntity.ok().body(objDto);
    }

    @GetMapping(value="/namesearch")
    public ResponseEntity<List<PlanetDTO>> findByName(@RequestParam(value="text", defaultValue="") String text) {
        text = URL.decodeParam(text);
        List<Planet> list = service.findByName(text);
        List<PlanetDTO> newList = new ArrayList<>();
        for (Planet planet : list) {
            newList.add(new PlanetDTO(planet));
            as.switcher("planets", planet.getName(), newList.get(list.indexOf(planet)));
        }
        if (!newList.isEmpty()) {
            return ResponseEntity.ok().body(newList);
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

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
