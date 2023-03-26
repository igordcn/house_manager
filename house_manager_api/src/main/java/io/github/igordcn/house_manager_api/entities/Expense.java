package io.github.igordcn.house_manager_api.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Expense")
public class Expense extends EntityBase {
    
    @Id
    private UUID id;
    
    private String name;

    private BigDecimal amount;

    private LocalDate date;

    @ManyToOne
    private Destination destination;
    
    @ManyToOne
    private Bank bank;

    @ManyToMany
    @JoinTable(
        name = "Expense_Category",
        joinColumns = @JoinColumn(name = "expense_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    private Expense(UUID id, String name, BigDecimal amount, LocalDate date, Destination destination, Bank bank) {
        super();
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.destination = destination;
        this.bank = bank;
    }

    private Expense(UUID id, String name, BigDecimal amount, LocalDate date, Destination destination, Bank bank,
                    List<Category> categories) {
        this(id, name, amount, date, destination, bank);
        this.categories = categories;
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

    public BigDecimal getAmount() {
        return amount;
    }

    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    private void setDate(LocalDate date) {
        this.date = date;
    }

    public Destination getDestination() {
        return destination;
    }

    private void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Bank getBank() {
        return bank;
    }

    private void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<Category> getCategories() {
        return categories;
    }

    private void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public static Expense create(String name, BigDecimal amount, LocalDate date, Destination destination, Bank bank,
                                 List<Category> categories) {
        var expense = new Expense(UUID.randomUUID(), name, amount, date, destination, bank, categories);
        expense.validate();
        return expense;
    }

    public void update(String name, BigDecimal amount, LocalDate date, Destination destination, Bank bank,
                       List<Category> categories) {
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.destination = destination;
        this.bank = bank;
        this.categories = categories;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(id, expense.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
