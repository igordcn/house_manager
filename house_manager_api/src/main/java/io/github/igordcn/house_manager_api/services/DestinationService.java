package io.github.igordcn.house_manager_api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.igordcn.house_manager_api.entities.Destination;
import io.github.igordcn.house_manager_api.repositories.DestinationRepository;

@Service
public class DestinationService {

    private DestinationRepository repository;

    public DestinationService(DestinationRepository repository) {
        this.repository = repository;
    }

    public List<Destination> findAll() {
        return repository.findAll();
    }

    public List<Destination> findByName(String name) {
        return repository.findByNameLike(name);
    }

    public Destination save(String name) {
        this

    }
    
}
