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
    public ResponseEntity<Bank> add(@RequestBody NamedResourceDto namedDto) {
        var bank = service.save(namedDto);
        var uri = UriComponentsBuilder.fromUriString("/banks/" + bank.getId()).build().toUri();
        return ResponseEntity.created(uri).body(bank);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
