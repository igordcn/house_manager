package io.github.igordcn.house_manager_api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.igordcn.house_manager_api.services.DestinationService;

@RestController
@RequestMapping("/destinations")
public class DestinationResource {
    @Autowired
    private DestinationService service;

    private DestinationResource(DestinationService service) {
        this.service = service;
    }
}
