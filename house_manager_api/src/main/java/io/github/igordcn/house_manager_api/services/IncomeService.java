package io.github.igordcn.house_manager_api.services;

import org.springframework.stereotype.Service;

import io.github.igordcn.house_manager_api.repositories.IncomeRepository;

@Service
public class IncomeService {
    
    private IncomeRepository repository;

    public IncomeService(IncomeRepository repository) {
        this.repository = repository;
    }

    

}
