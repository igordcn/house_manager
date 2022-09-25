package io.github.igordcn.house_manager_api.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Income {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double amount;
    private LocalDate date;
    @ManyToOne
    private Origin origem;
}
