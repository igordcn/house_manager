package io.github.igordcn.house_manager_api.entities;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Category")
public class Category extends EntityBase {
    
    @Id
    private UUID id;

    private String name;

    protected Category() {}

    private Category(UUID id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    public static Category create(final String name) {
        var category = new Category(UUID.randomUUID(), name);
        category.validate();
        return category;
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
        Category category = (Category) o;
        return Objects.equals(getId(), category.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
