package io.github.igordcn.house_manager_api.dto;

public record NamedResourceDto (
    @NotNull String name
    ) {

    public NamedResource(String name) {
        this.name = name;
        validate
    }

    public 
}
