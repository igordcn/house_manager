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
import io.github.igordcn.house_manager_api.entities.Destination;
import io.github.igordcn.house_manager_api.services.DestinationService;

@RestController
@RequestMapping("/destinations")
public class DestinationResource {
    
    private DestinationService service;

    public DestinationResource(DestinationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Destination>> getByName(@RequestParam String name) {
        var destinations = (name == null || name.isBlank())? service.findAll() : service.findByName(name);
        return ResponseEntity.ok(destinations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destination> getById(@PathVariable UUID id) {
        var destination = service.findById(id).orElseThrow();
        return ResponseEntity.ok(destination);
    }

    @PostMapping
    public ResponseEntity<Destination> add(@RequestBody NamedResourceDto namedDto) {
        var destination = service.save(namedDto);
        var uri = UriComponentsBuilder.fromUriString("/destinations/" + destination.getId()).build().toUri();
        return ResponseEntity.created(uri).body(destination);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
