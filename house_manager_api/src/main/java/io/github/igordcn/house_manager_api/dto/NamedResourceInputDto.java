package io.github.igordcn.house_manager_api.dto;

import javax.validation.constraints.NotBlank;

public class NamedResourceInputDto {
    
    @NotBlank(message="The field 'name' should not be null")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
