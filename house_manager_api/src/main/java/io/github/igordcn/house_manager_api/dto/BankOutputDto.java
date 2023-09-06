package io.github.igordcn.house_manager_api.dto;

import io.github.igordcn.house_manager_api.entities.Bank;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

public class BankOutputDto extends RepresentationModel<BankOutputDto> {

    private UUID id;

    private String name;

    public BankOutputDto(Bank bank) {
        this.id = bank.getId();
        this.name = bank.getName();
    }

    public UUID getId() { return id; }

    public String getName() {
        return name;
    }

    public static BankOutputDto from(Bank bank) {
        return new BankOutputDto(bank);
    }

}
