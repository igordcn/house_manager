package io.github.igordcn.house_manager_api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

import io.github.igordcn.house_manager_api.dto.NamedResourceInputDto;
import io.github.igordcn.house_manager_api.entities.Destination;
import io.github.igordcn.house_manager_api.mapper.NamedMapper;
import io.github.igordcn.house_manager_api.repositories.DestinationRepository;

@Service
public class DestinationService {

    private DestinationRepository repository;

    private NamedMapper namedMapper;

    public DestinationService(DestinationRepository repository, NamedMapper namedMapper) {
        this.repository = repository;
        this.namedMapper = namedMapper;
    }

    public List<Destination> findAll() {
        return repository.findAll();
    }

    public Optional<Destination> findById(UUID id) {
        return repository.findById(id);
    }

    public List<Destination> findByName(String name) {
        return repository.findByNameContaining(name);
    }

    public Destination save(NamedResourceInputDto dto) {
        var destination = namedMapper.namedResourceDtoToDestination(dto);
        return repository.save(destination);
    }

    public void delete(Destination destination) {
        repository.delete(destination);
    }

    public void delete(UUID id) {
        var destination = findById(id).orElseThrow();
        delete(destination);
    }
    
}
