package io.github.igordcn.house_manager_api.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.igordcn.house_manager_api.entities.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, UUID>, ExpenseQueryRepository {
    
}
