package io.github.igordcn.house_manager_api.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class NamedResourceDto {
    
    @NotBlank
    private String name;

}
