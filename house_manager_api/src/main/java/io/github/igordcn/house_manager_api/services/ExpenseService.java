package io.github.igordcn.house_manager_api.services;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.igordcn.house_manager_api.entities.Expense;
import io.github.igordcn.house_manager_api.repositories.ExpenseRepository;

@Service
public class ExpenseService {
    
    private ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public Page<Expense> findByCategoryBankDestinationAndInterval(UUID categoryId, UUID destinationId, UUID bankId,
        LocalDate dateStart, LocalDate dateEnd, Pageable pageable) {
        return repository.findByCategoryAndDestinationAndBankAndDateBetween(categoryId, destinationId, bankId,
            dateStart, dateEnd, pageable);
    }

    public Optional<Expense> findById(UUID id) {
        return repository.findById(id);
    }
    
    public Expense save(Expense expense) {
        return repository.save(expense);
    }

    public void delete(Expense expense) {
        repository.delete(expense);
    }

    public void delete(UUID id) {
        var expense = findById(id).orElseThrow();
        delete(expense);
    }
    
}
