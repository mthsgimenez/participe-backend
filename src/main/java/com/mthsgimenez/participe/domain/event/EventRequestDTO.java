package com.mthsgimenez.participe.domain.event;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;
import java.time.OffsetDateTime;

public record EventRequestDTO(
        @NotEmpty String name,
        String description,
        @NotNull OffsetDateTime date,
        MultipartFile image
){}
