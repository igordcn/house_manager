package io.github.igordcn.house_manager_api.services;

import org.springframework.stereotype.Service;

import io.github.igordcn.house_manager_api.repositories.DestinationRepository;

@Service
public class DestinationService {

    private DestinationRepository repository;

    public DestinationService(DestinationRepository repository) {
        this.repository = repository;
    }
    
}
