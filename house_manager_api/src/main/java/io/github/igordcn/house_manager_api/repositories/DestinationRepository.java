package io.github.igordcn.house_manager_api.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.igordcn.house_manager_api.entities.Destination;

@Repository
public interface DestinationRepository extends CrudRepository<Destination, UUID> {

    List<Destination> findAll();
    
    List<Destination> findByNameLike(String name);

}
