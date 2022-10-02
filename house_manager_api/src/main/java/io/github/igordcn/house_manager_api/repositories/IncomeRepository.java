package io.github.igordcn.house_manager_api.repositories;


import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.github.igordcn.house_manager_api.entities.Income;
import io.github.igordcn.house_manager_api.entities.Origin;

@Repository
public interface IncomeRepository extends PagingAndSortingRepository<Income, UUID> {

    Page<Income> findByDateBetween(LocalDate dateStart, LocalDate dateEnd, Pageable pageable);

    Page<Income> findByOriginAndDateBetween(Origin origin, LocalDate dateStart, LocalDate dateEnd, Pageable pageable);

    Page<Income> findByNameAndDateBetween(String name, LocalDate dateStart, LocalDate dateEnd, Pageable pageable);

}
