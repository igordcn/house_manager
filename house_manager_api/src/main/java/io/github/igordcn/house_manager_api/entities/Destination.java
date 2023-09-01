package io.github.igordcn.house_manager_api.entities;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Destination")
public class Destination extends EntityBase {
    
    @Id
    private UUID id;

    private String name;

    public Destination() {}

    private Destination(UUID id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public static Destination create(final String name) {
        var destination = new Destination(UUID.randomUUID(), name);
        destination.validate();
        return destination;
    }

    public void update(final String name) {
        this.name = name;
        this.updatedAt = Instant.now();
        this.validate();
    }

    protected void validate() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
