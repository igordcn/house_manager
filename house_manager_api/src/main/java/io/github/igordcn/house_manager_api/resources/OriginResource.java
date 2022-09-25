package io.github.igordcn.house_manager_api.resources;

import io.github.igordcn.house_manager_api.services.OriginService;

public class OriginResource {
    private OriginService service;

    public OriginResource(OriginService service) {
        this.service = service;
    }
}
