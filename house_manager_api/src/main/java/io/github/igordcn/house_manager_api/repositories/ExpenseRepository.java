package io.github.igordcn.house_manager_api.repositories;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import io.github.igordcn.house_manager_api.entities.Bank;
import io.github.igordcn.house_manager_api.entities.Category;
import io.github.igordcn.house_manager_api.entities.Destination;
import io.github.igordcn.house_manager_api.entities.Expense;

public interface ExpenseRepository extends PagingAndSortingRepository<Expense, UUID> {
    
    Page<Expense> findByCategoryAndDateBetween(Category category, LocalDate dateStart, LocalDate dateEnd, Pageable pageable);

    Page<Expense> findByDestinationAndDateBetween(Destination destination, LocalDate dateStart, LocalDate dateEnd, Pageable pageable);

    Page<Expense> findByBankAndDateBetween(Bank bank, LocalDate dateStart, LocalDate dateEnd, Pageable pageable);
    
}
