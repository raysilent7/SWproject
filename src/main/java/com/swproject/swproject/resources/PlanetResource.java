package com.swproject.swproject.resources;

import com.swproject.swproject.domain.Planet;
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
    public ResponseEntity<List<Planet>> findAll() {
        List<Planet> list = service.findAll();
        List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
