package io.github.igordcn.house_manager_api.resources;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import io.github.igordcn.house_manager_api.entities.Income;
import io.github.igordcn.house_manager_api.services.IncomeService;

@RestController
@RequestMapping("/incomes")
public class IncomeResource {
    
    private IncomeService service;

    public IncomeResource(IncomeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Income>> getPage(
        @RequestParam UUID originId,
        @RequestParam String name,
        @RequestParam LocalDate dateStart,
        @RequestParam LocalDate dateEnd,
        @RequestParam Pageable pageable
    ) {
        var income = service.findByNameAndOriginAndInterval(originId, name, dateStart, dateEnd, pageable);
        return ResponseEntity.ok(income);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Income> getById(@PathVariable UUID id) {
        var income = service.findById(id).orElseThrow();
        return ResponseEntity.ok(income);
    }

    @PostMapping
    public ResponseEntity<Income> add(@RequestBody Income namedDto) {
        var destination = service.save(namedDto);
        var uri = UriComponentsBuilder.fromUriString("/incomes/" + destination.getId()).build().toUri();
        return ResponseEntity.created(uri).body(destination);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
