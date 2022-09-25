package io.github.igordcn.house_manager_api.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Origin {
    private Long id;
    private String name;
}
