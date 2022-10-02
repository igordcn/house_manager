package io.github.igordcn.house_manager_api.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.igordcn.house_manager_api.services.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseResource {
    
    private ExpenseService service;

    public ExpenseResource(ExpenseService service) {
        this.service = service;
    }

}
