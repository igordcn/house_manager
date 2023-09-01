package io.github.igordcn.house_manager_api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.igordcn.house_manager_api.dto.NamedResourceInputDto;
import io.github.igordcn.house_manager_api.entities.Bank;
import io.github.igordcn.house_manager_api.repositories.BankRepository;

@Service
public class BankService {
    
    private BankRepository repository;

    public BankService(BankRepository repository) {
        this.repository = repository;
    }

    public List<Bank> findAll() {
        return repository.findAll();
    }

    public Optional<Bank> findById(UUID id) {
        return repository.findById(id);
    }

    public List<Bank> findByName(String name) {
        return repository.findByNameContaining(name);
    }

    public Bank insert(NamedResourceInputDto dto) {
        var bank = Bank.create(dto.getName());
        return repository.save(bank);
    }

    public void update(UUID id, NamedResourceInputDto dto) {
        var bank = repository.findById(id).orElseThrow();
        bank.update(dto.getName());
        repository.save(bank);
    }

    public void delete(Bank bank) {
        bank.delete();
        repository.save(bank);
    }

    public void delete(UUID id) {
        var bank = findById(id).orElseThrow();
        delete(bank);
    }

}
