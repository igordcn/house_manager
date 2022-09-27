package io.github.igordcn.house_manager_api.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.igordcn.house_manager_api.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID>  {
    
    List<Category> findByNameLike(String name);
    
}
