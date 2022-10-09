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
import io.github.igordcn.house_manager_api.entities.Origin;
import io.github.igordcn.house_manager_api.services.OriginService;

@RestController
@RequestMapping("/origins")
public class OriginResource {
    
    private OriginService service;

    public OriginResource(OriginService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Origin>> getByName(@RequestParam(required = false) String name) {
        var origins = (name == null || name.isBlank())? service.findAll() : service.findByName(name);
        return ResponseEntity.ok(origins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Origin> getById(@PathVariable UUID id) {
        var origin = service.findById(id).orElseThrow();
        return ResponseEntity.ok(origin);
    }

    @PostMapping
    public ResponseEntity<Origin> add(@RequestBody NamedResourceDto namedDto) {
        var origin = service.save(namedDto);
        var uri = UriComponentsBuilder.fromUriString("/origins/" + origin.getId()).build().toUri();
        return ResponseEntity.created(uri).body(origin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
