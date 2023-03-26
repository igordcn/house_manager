package io.github.igordcn.house_manager_api.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "Income")
public class Income extends EntityBase {
    
    @Id
    private UUID id;

    private String name;

    private BigDecimal amount;

    private LocalDate date;

    @ManyToOne
    private Origin origin;

    private Income() {}

    private Income(final UUID id, final String name, final BigDecimal amount, final LocalDate date,
                   final Origin origin) {
        super();
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.origin = origin;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Origin getOrigin() {
        return origin;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    private void setDate(LocalDate date) {
        this.date = date;
    }

    private void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public static Income create(final String name, final BigDecimal amount, final LocalDate date,
                                final Origin origin) {
        var income = new Income(UUID.randomUUID(), name, amount, date, origin);
        income.validate();
        return income;
    }

    public void update(final String name, final BigDecimal amount, final LocalDate date, final Origin origin) {
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.origin = origin;
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
        if (amount == null) {
            throw new IllegalStateException("Amount should not be null!");
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalStateException("Amount should not be less than 0!");
        }
        if (date == null) {
            throw new IllegalStateException("Date should not be null!");
        }
        if (date.isBefore(LocalDate.of(2010, 1, 1))) {
            throw new IllegalStateException("Date should be after 2010!");
        }
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalStateException("Date should not be future!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Income income = (Income) o;
        return getId().equals(income.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
