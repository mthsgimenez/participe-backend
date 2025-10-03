package com.mthsgimenez.participe.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record LoginDTO(
        @NotEmpty @Email String email,
        @NotEmpty String password
){}
