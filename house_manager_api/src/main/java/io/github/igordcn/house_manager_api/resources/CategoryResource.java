package io.github.igordcn.house_manager_api.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.github.igordcn.house_manager_api.dto.NamedResourceDto;
import io.github.igordcn.house_manager_api.entities.Category;
import io.github.igordcn.house_manager_api.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    private CategoryService service;
    
    public CategoryResource(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getByName(@RequestParam String name) {
        var categories = (name == null || name.isBlank())? service.findAll() : service.findByName(name);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable UUID id) {
        var category = service.findById(id).orElseThrow();
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> add(@RequestBody NamedResourceDto namedDto) {
        var category = service.save(namedDto);
        var uri = UriComponentsBuilder.fromUriString("/categories/" + category.getId()).build().toUri();
        return ResponseEntity.created(uri).body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
