package io.github.igordcn.house_manager_api.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.igordcn.house_manager_api.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID>  {
    
    List<Category> findByNameLike(String name);
    
}
