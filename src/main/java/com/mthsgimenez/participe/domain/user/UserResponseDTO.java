package com.mthsgimenez.participe.domain.user;

import com.mthsgimenez.participe.domain.company.Company;

public record UserResponseDTO(
        Long id,
        String name,
        UserRole role,
        Company company
) {}
