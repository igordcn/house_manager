package io.github.igordcn.house_manager_api.entities;

import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;


public abstract class EntityBase implements Serializable {

    protected Instant createdAt;

    protected Instant updatedAt;

    protected Instant deletedAt;

    protected EntityBase() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public boolean isDeleted() {
        return deletedAt != null;
    }

    public void delete() {
        this.deletedAt = Instant.now();
    }

    public void revertDelete() {
        this.deletedAt = null;
    }

    protected abstract void validate();

}
