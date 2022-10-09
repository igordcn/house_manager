package io.github.igordcn.house_manager_api.repositories;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.github.igordcn.house_manager_api.entities.Expense;

public interface ExpenseQueryRepository {
    
    Page<Expense> findByCategoryAndDestinationAndBankAndDateBetween(
        UUID categoryId, UUID destinationId, UUID bankId, LocalDate dateStart, LocalDate dateEnd, Pageable pageable);

}
