package io.github.igordcn.house_manager_api.repositories;

import org.springframework.data.repository.Repository;

import io.github.igordcn.house_manager_api.entities.Expense;

public interface ExpenseRepository extends Repository<Expense, Long> {
    
}
