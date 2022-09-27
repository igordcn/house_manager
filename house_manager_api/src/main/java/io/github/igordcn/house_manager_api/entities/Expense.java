package io.github.igordcn.house_manager_api.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "Expense")
public class Expense {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    
    private String name;

    private Double amount;

    private LocalDate date;

    @ManyToOne
    private Destination destination;
    
    @ManyToOne
    private Bank bank;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    public Expense(String name, Double amount, LocalDate date, Destination destination, Bank bank) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.destination = destination;
        this.bank = bank;
        validate();
    }

    public Expense(String name, Double amount, LocalDate date, Destination destination, Bank bank, List<Category> categories) {
        this(name, amount, date, destination, bank);
        this.categories = categories;
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
        if (amount == null) {
            throw new IllegalStateException("Amount should not be null!");
        }
        if (amount < 0) {
            throw new IllegalStateException("Amount should not be lesser than 0!");
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
        if (destination == null) {
            throw new IllegalStateException("Destination should not be null!");
        }
        if (bank == null) {
            throw new IllegalStateException("Bank should not be null!");
        }
    }

}
