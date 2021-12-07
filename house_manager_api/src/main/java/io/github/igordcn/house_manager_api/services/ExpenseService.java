package io.github.igordcn.house_manager_api.services;

import org.springframework.stereotype.Service;

import io.github.igordcn.house_manager_api.repositories.ExpenseRepository;

@Service
public class ExpenseService {
    
    private ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }
}
