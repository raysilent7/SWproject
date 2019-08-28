package com.swproject.swproject.repository;

import com.swproject.swproject.domain.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String> {

    @Query("{'name':{ $regex: '^?0', $options: 'i'}}")
    List<Planet> findByName(String text);
}
