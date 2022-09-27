package io.github.igordcn.house_manager_api.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.igordcn.house_manager_api.entities.Origin;

@Repository
public interface OriginRepository extends CrudRepository<Origin, UUID> {
    
    List<Origin> findAll();

    List<Origin> findByNameLike(String name);

}
