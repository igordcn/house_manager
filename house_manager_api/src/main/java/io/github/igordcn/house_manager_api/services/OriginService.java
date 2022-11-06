package io.github.igordcn.house_manager_api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.igordcn.house_manager_api.dto.NamedResourceDto;
import io.github.igordcn.house_manager_api.entities.Origin;
import io.github.igordcn.house_manager_api.mapper.NamedMapper;
import io.github.igordcn.house_manager_api.repositories.OriginRepository;

@Service
public class OriginService {

    private OriginRepository repository;

    private NamedMapper namedMapper;

    public OriginService(OriginRepository repository, NamedMapper namedMapper) {
        this.repository = repository;
        this.namedMapper = namedMapper;
    }

    public List<Origin> findAll() {
        return repository.findAll();
    }

    public Optional<Origin> findById(UUID id) {
        return repository.findById(id);
    }

    public List<Origin> findByName(String name) {
        return repository.findByNameContaining(name);
    }
    
    public Origin save(NamedResourceDto dto) {
        var origin = namedMapper.namedResourceDtoToOrigin(dto);
        return repository.save(origin);
    }

    public void delete(Origin origin) {
        repository.delete(origin);
    }

    public void delete(UUID id) {
        var origin = findById(id).orElseThrow();
        delete(origin);
    }
    
}
