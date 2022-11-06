package io.github.igordcn.house_manager_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import io.github.igordcn.house_manager_api.dto.NamedResourceDto;
import io.github.igordcn.house_manager_api.entities.Bank;
import io.github.igordcn.house_manager_api.entities.Category;
import io.github.igordcn.house_manager_api.entities.Destination;
import io.github.igordcn.house_manager_api.entities.Origin;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NamedMapper {
    
    Bank namedResourceDtoToBank(NamedResourceDto dto);

    Category namedResourceDtoToCategory(NamedResourceDto dto);

    Destination namedResourceDtoToDestination(NamedResourceDto dto);

    Origin namedResourceDtoToOrigin(NamedResourceDto dto);

}
