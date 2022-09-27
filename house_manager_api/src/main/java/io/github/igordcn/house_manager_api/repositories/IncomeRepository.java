package io.github.igordcn.house_manager_api.repositories;


import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.igordcn.house_manager_api.entities.Income;

@Repository
public interface IncomeRepository extends CrudRepository<Income, UUID> {

    List<Income> findByNameLike(String name);

}
