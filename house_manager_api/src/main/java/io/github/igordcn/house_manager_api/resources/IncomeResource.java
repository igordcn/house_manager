package io.github.igordcn.house_manager_api.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.igordcn.house_manager_api.services.IncomeService;

@RestController
@RequestMapping("/incomes")
public class IncomeResource {
    private IncomeService service;

    public IncomeResource(IncomeService service) {
        this.service = service;
    }
}
