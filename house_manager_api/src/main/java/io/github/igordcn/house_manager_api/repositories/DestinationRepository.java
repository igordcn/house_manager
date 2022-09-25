package io.github.igordcn.house_manager_api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import io.github.igordcn.house_manager_api.entities.Destination;

public interface DestinationRepository extends Repository<Destination, Long> {
    List<Destination> findAll();
    List<Destination> findByNomeLike(String nome);
}
