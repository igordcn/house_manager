package io.github.igordcn.house_manager_api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.igordcn.house_manager_api.dto.NamedResourceInputDto;
import io.github.igordcn.house_manager_api.entities.Bank;
import io.github.igordcn.house_manager_api.mapper.NamedMapper;
import io.github.igordcn.house_manager_api.repositories.BankRepository;

@Service
public class BankService {
    
    private BankRepository repository;

    private NamedMapper namedMapper;

    public BankService(BankRepository repository, NamedMapper namedMapper) {
        this.repository = repository;
        this.namedMapper = namedMapper;
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

    public Bank save(NamedResourceInputDto dto) {
        var bank = namedMapper.namedResourceDtoToBank(dto);
        return repository.save(bank);
    }

    public void delete(Bank bank) {
        repository.delete(bank);
    }

    public void delete(UUID id) {
        var bank = findById(id).orElseThrow();
        delete(bank);
    }

}
