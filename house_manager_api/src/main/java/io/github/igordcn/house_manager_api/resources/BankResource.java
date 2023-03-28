package io.github.igordcn.house_manager_api.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import io.github.igordcn.house_manager_api.dto.NamedResourceInputDto;
import io.github.igordcn.house_manager_api.entities.Bank;
import io.github.igordcn.house_manager_api.services.BankService;

@RestController
@RequestMapping("/banks")
public class BankResource {
    
    private BankService service;

    public BankResource(BankService bankService) {
        this.service = bankService;
    }

    @GetMapping
    public ResponseEntity<List<Bank>> getByName(@RequestParam(required = false) String name) {
        var banks = (name == null || name.isBlank())? service.findAll() : service.findByName(name);
        return ResponseEntity.ok(banks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bank> getById(@PathVariable UUID id) {
        var bank = service.findById(id).orElseThrow();
        return ResponseEntity.ok(bank);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody NamedResourceInputDto namedDto) {
        var bank = service.insert(namedDto);
        var uri = UriComponentsBuilder.fromUriString("/banks/" + bank.getId()).build().toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody NamedResourceInputDto namedDto) {
        service.update(id, namedDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
