package io.github.igordcn.house_manager_api.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import io.github.igordcn.house_manager_api.entities.Bank;

public interface BankRepository extends CrudRepository<Bank, UUID> {

    List<Bank> findAll();
    
    List<Bank> findByNameLike(String name);
    
}
