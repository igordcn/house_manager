package io.github.igordcn.house_manager_api.entities;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Origin")
public class Origin extends EntityBase {

    @Id
    private UUID id;

    private String name;

    protected Origin() {}

    private Origin(final UUID id, final String name) {
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

    public static Origin create(final String name) {
        var origin = new Origin(UUID.randomUUID(), name);
        origin.validate();
        return origin;
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
        Origin origin = (Origin) o;
        return Objects.equals(id, origin.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
