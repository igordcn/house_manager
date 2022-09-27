package io.github.igordcn.house_manager_api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.igordcn.house_manager_api.entities.Origin;
import io.github.igordcn.house_manager_api.repositories.OriginRepository;

@Service
public class OriginService {

    private OriginRepository repository;

    public OriginService(OriginRepository repository) {
        this.repository = repository;
    }

    public List<Origin> findByName(String name) {
        return repository.findByNameLike(name);
    }
    
}
