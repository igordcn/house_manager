package io.github.igordcn.house_manager_api.services;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.igordcn.house_manager_api.entities.Income;
import io.github.igordcn.house_manager_api.repositories.IncomeRepository;

@Service
public class IncomeService {
    
    private IncomeRepository repository;

    public IncomeService(IncomeRepository repository) {
        this.repository = repository;
    }

    public Page<Income> findByNameAndOriginAndInterval(UUID originId, String name, LocalDate dateStart, LocalDate dateEnd, Pageable pageable) {
        return repository.findByOriginIdAndNameLikeAndDateBetween(originId, name, dateStart, dateEnd, pageable);
    }

    public Optional<Income> findById(UUID id) {
        return repository.findById(id);
    }
    
    public Income save(Income income) {
        return repository.save(income);
    }

    public void delete(Income income) {
        repository.delete(income);
    }

    public void delete(UUID id) {
        var income = findById(id).orElseThrow();
        delete(income);
    }

}
