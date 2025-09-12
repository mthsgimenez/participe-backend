package com.mthsgimenez.participe.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityNotFoundException extends RuntimeException {
    private Class<?> entity;
    private Long searchedId;

    public EntityNotFoundException(Class<?> entity, Long searchedId) {
        super(String.format("%s with ID %s not found", entity.getSimpleName(), searchedId));
        this.entity = entity;
        this.searchedId = searchedId;
    }
}
