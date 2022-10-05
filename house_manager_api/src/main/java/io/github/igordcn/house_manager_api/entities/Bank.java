package io.github.igordcn.house_manager_api.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter(AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"id"})
@ToString
@Entity
@Table(name = "Bank")
public class Bank implements Serializable {
    
    @Id
    private UUID id;

    private String name;

    public Bank(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        validate();
    }

    private void validate() {
        if (id == null) {
            throw new IllegalStateException("Id should not be null!");
        }
        if (name == null) {
            throw new IllegalStateException("Name should not be null!");
        }
        if (name.isBlank()) {
            throw new IllegalStateException("Name should not be blank!");
        }
    }

}
