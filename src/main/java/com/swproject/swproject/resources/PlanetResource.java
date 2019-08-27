package com.swproject.swproject.resources;

import com.swproject.swproject.domain.Planet;
import com.swproject.swproject.domain.dto.PlanetDTO;
import com.swproject.swproject.resources.util.URL;
import com.swproject.swproject.services.PlanetService;
import com.swproject.swproject.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
