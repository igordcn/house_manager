package io.github.igordcn.house_manager_api.resources;

import java.util.List;
import java.util.UUID;

import io.github.igordcn.house_manager_api.dto.BankOutputDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import io.github.igordcn.house_manager_api.dto.NamedResourceInputDto;
import io.github.igordcn.house_manager_api.entities.Bank;
import io.github.igordcn.house_manager_api.services.BankService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/banks")
public class BankResource {
    
    private BankService service;

    public BankResource(BankService bankService) {
        this.service = bankService;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<BankOutputDto>> getByName(@RequestParam(required = false) String name) {
        var banks = (name == null || name.isBlank())? service.findAll() : service.findByName(name);
        var banksDto = banks.stream().map(BankOutputDto::from).toList();
        for (var bankDto : banksDto) {
            bankDto.add(linkTo(methodOn(BankResource.class).getById(bankDto.getId())).withSelfRel());
        }
        Link link = linkTo(methodOn(BankResource.class)).withSelfRel();
        var banksLinks = CollectionModel.of(banksDto, link);
        return ResponseEntity.ok(banksLinks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankOutputDto> getById(@PathVariable UUID id) {
        var bank = service.findById(id).orElseThrow();
        var bankDto = BankOutputDto.from(bank);
        bankDto.add(linkTo(methodOn(BankResource.class).getById(id)).withSelfRel());
        return ResponseEntity.ok(bankDto);
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
