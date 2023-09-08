package io.github.igordcn.house_manager_api.resources;

import io.github.igordcn.house_manager_api.dto.BankOutputDto;
import io.github.igordcn.house_manager_api.dto.NamedResourceInputDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/banks")
public interface BankResource {

    @GetMapping
    ResponseEntity<CollectionModel<BankOutputDto>> get(@RequestParam(required = false) String name);

    @GetMapping("/{id}")
    ResponseEntity<BankOutputDto> getById(@PathVariable UUID id);

    @PostMapping
    ResponseEntity<Void> add(@RequestBody NamedResourceInputDto namedDto);

    @PutMapping("/{id}")
    ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody NamedResourceInputDto namedDto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> remove(@PathVariable UUID id);

}
