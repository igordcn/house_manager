package io.github.igordcn.house_manager_api.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import io.github.igordcn.house_manager_api.entities.Origin;

public interface OriginRepository extends Repository<Origin, Long> {
    List<Origin> findAll();
    List<Origin> findByNomeLike(String nome);
}
