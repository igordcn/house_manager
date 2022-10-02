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

    private CategoryService categoryService;

    private DestinationService destinationService;

    private BankService bankService;

    public ExpenseService(ExpenseRepository repository, CategoryService categoryService, DestinationService destinationService,
        BankService bankService) {
        this.repository = repository;
        this.categoryService = categoryService;
        this.destinationService = destinationService;
        this.bankService = bankService;
    }

    public Page<Expense> findByInterval(LocalDate dateStart, LocalDate dateEnd, Pageable pageable) {
        return repository.findByDateBetween(dateStart, dateEnd, pageable);
    }

    public Page<Expense> findByCategoryAndInterval(UUID categoryId, LocalDate dateStart, LocalDate dateEnd, Pageable pageable) {
        var category = categoryService.findById(categoryId).orElseThrow();
        return repository.findByCategoryAndDateBetween(category, dateStart, dateEnd, pageable);
    }

    public Page<Expense> findByDestinationAndInterval(UUID destinationId, LocalDate dateStart, LocalDate dateEnd, Pageable pageable) {
        var destination = destinationService.findById(destinationId).orElseThrow();
        return repository.findByDestinationAndDateBetween(destination, dateStart, dateEnd, pageable);
    }

    public Page<Expense> findByBankAndInterval(UUID bankId, LocalDate dateStart, LocalDate dateEnd, Pageable pageable) {
        var bank = bankService.findById(bankId).orElseThrow();
        return repository.findByBankAndDateBetween(bank, dateStart, dateEnd, pageable);
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
