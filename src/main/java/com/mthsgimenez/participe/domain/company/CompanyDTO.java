package com.mthsgimenez.participe.domain.company;

import jakarta.validation.constraints.NotEmpty;

public record CompanyDTO(
        @NotEmpty(message = "Company name must not be empty")
        String name
){}
