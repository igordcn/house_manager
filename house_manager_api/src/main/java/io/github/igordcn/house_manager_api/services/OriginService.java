package io.github.igordcn.house_manager_api.services;

import org.springframework.stereotype.Service;

import io.github.igordcn.house_manager_api.repositories.OriginRepository;

@Service
public class OriginService {
    private OriginRepository repository;

    public OriginService(OriginRepository repository) {
        this.repository = repository;
    }
}
