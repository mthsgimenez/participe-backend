package com.mthsgimenez.participe.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @NotEmpty String name,
        @NotEmpty @Email String email,
        @NotNull Long companyId,
        @NotEmpty String password
){}
