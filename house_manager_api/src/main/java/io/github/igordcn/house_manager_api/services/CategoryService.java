package io.github.igordcn.house_manager_api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.igordcn.house_manager_api.dto.NamedResourceDto;
import io.github.igordcn.house_manager_api.entities.Category;
import io.github.igordcn.house_manager_api.mapper.NamedMapper;
import io.github.igordcn.house_manager_api.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    private CategoryRepository repository;

    private NamedMapper namedMapper;

    public CategoryService(CategoryRepository repository, NamedMapper namedMapper) {
        this.repository = repository;
        this.namedMapper = namedMapper;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Optional<Category> findById(UUID id) {
        return repository.findById(id);
    }

    public List<Category> findByName(String name) {
        return repository.findByNameContaining(name);
    }

    public Category save(NamedResourceDto dto) {
        var category = namedMapper.namedResourceDtoToCategory(dto);
        return repository.save(category);
    }

    public void delete(Category category) {
        repository.delete(category);
    }

    public void delete(UUID id) {
        var category = findById(id).orElseThrow();
        delete(category);
    }

}
