package io.github.igordcn.house_manager_api.dto;

import io.github.igordcn.house_manager_api.entities.Bank;
import org.springframework.hateoas.RepresentationModel;

public class BankOutputDto extends RepresentationModel<BankOutputDto> {

    private String name;

    public BankOutputDto(Bank bank) {
        this.name = bank.getName();
    }

    public String getName() {
        return name;
    }

    public static BankOutputDto from(Bank bank) {
        return new BankOutputDto(bank);
    }

}
