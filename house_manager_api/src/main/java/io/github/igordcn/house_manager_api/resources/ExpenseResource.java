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

import io.github.igordcn.house_manager_api.entities.Expense;
import io.github.igordcn.house_manager_api.services.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseResource {
    
    private ExpenseService service;

    public ExpenseResource(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Expense>> getPage(
        @RequestParam UUID categoryId,
        @RequestParam UUID destinationId,
        @RequestParam UUID bankId,
        @RequestParam LocalDate dateStart,
        @RequestParam LocalDate dateEnd,
        @RequestParam Pageable pageable
    ) {
        var expense = service.findByCategoryBankDestinationAndInterval(categoryId, destinationId, bankId, dateStart, dateEnd, pageable);
        return ResponseEntity.ok(expense);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getById(@PathVariable UUID id) {
        var expense = service.findById(id).orElseThrow();
        return ResponseEntity.ok(expense);
    }

    @PostMapping
    public ResponseEntity<Expense> add(@RequestBody Expense namedDto) {
        var destination = service.save(namedDto);
        var uri = UriComponentsBuilder.fromUriString("/expenses/" + destination.getId()).build().toUri();
        return ResponseEntity.created(uri).body(destination);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
