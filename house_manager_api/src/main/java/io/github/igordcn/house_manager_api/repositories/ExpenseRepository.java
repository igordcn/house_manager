package io.github.igordcn.house_manager_api.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import io.github.igordcn.house_manager_api.entities.Destination;
import io.github.igordcn.house_manager_api.entities.Expense;
import io.github.igordcn.house_manager_api.enums.Bank;
import io.github.igordcn.house_manager_api.enums.Category;

public interface ExpenseRepository extends PagingAndSortingRepository<Expense, Long> {
    Page<Expense> findByCategoryAndDateBetween(Category category, LocalDate dateStart, LocalDate dateEnd, Pageable pageable);

    Page<Expense> findByDestinationAndDateBetween(Destination destination, LocalDate dateStart, LocalDate dateEnd, Pageable pageable);

    Page<Expense> findByBankAndDateBetween(Bank bank, LocalDate dateStart, LocalDate dateEnd, Pageable pageable);
}
