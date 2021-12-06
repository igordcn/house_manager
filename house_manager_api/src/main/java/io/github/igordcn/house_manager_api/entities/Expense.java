package io.github.igordcn.house_manager_api.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.github.igordcn.house_manager_api.enums.Bank;
import io.github.igordcn.house_manager_api.enums.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double amount;
    private LocalDate data;
    private Category category;
    private Bank bank;
    @ManyToOne
    private Destination destination;
}
