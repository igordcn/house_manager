package io.github.igordcn.house_manager_api.resources;

import java.util.List;
import java.util.UUID;

import io.github.igordcn.house_manager_api.dto.BankOutputDto;
import io.github.igordcn.house_manager_api.entities.Bank;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import io.github.igordcn.house_manager_api.dto.NamedResourceInputDto;
import io.github.igordcn.house_manager_api.services.BankService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class BankResourceImpl implements BankResource {
    
    private final BankService service;

    public BankResourceImpl(BankService bankService) {
        this.service = bankService;
    }

    public ResponseEntity<CollectionModel<BankOutputDto>> get(String name) {
        return isParamBlankOrNull(name)? getAll() : getByName(name);
    }

    public ResponseEntity<BankOutputDto> getById(UUID id) {
        var bank = service.findById(id).orElseThrow();
        var bankDto = BankOutputDto.from(bank);
        bankDto.add(linkTo(methodOn(BankResourceImpl.class).getById(id)).withSelfRel());
        return ResponseEntity.ok(bankDto);
    }

    public ResponseEntity<Void> add(NamedResourceInputDto namedDto) {
        var bank = service.insert(namedDto);
        var uri = UriComponentsBuilder.fromUriString("/banks/" + bank.getId()).build().toUri();
        return ResponseEntity.created(uri).build();
    }

    public ResponseEntity<Void> update(UUID id, NamedResourceInputDto namedDto) {
        service.update(id, namedDto);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> remove(UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private boolean isParamBlankOrNull(String param) {
        return param == null || param.isBlank();
    }

    private ResponseEntity<CollectionModel<BankOutputDto>> getAll() {
        var link = linkTo(BankResourceImpl.class).withSelfRel();
        var banks = service.findAll();
        var banksLinks = parseToDtoWithLinks(banks, link);
        return ResponseEntity.ok(banksLinks);
    }

    private ResponseEntity<CollectionModel<BankOutputDto>> getByName(String name) {
        var link = linkTo(BankResourceImpl.class).slash("?name=" + name).withSelfRel();
        var banks = service.findByName(name);
        var banksLinks = parseToDtoWithLinks(banks, link);
        return ResponseEntity.ok(banksLinks);
    }

    private CollectionModel<BankOutputDto> parseToDtoWithLinks(List<Bank> banks, Link link) {
        var banksDto = banks.stream().map(BankOutputDto::from).toList();
        for (var bankDto : banksDto) {
            bankDto.add(linkTo(methodOn(BankResourceImpl.class).getById(bankDto.getId())).withSelfRel());
        }
        return CollectionModel.of(banksDto, link);
    }
    
}
