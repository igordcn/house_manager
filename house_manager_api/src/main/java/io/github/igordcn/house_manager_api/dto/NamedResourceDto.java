package io.github.igordcn.house_manager_api.dto;

import javax.validation.constraints.NotBlank;

public record NamedResourceDto (@NotBlank String name) {}
