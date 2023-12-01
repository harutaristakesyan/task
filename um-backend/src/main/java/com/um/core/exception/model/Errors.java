package com.um.core.exception.model;

import lombok.Getter;

@Getter
public enum Errors {
    ENTITY_NOT_FOUND(1, "Entity {0} with id = {1} not found");

    private final int errorCode;
    private final String errorMessage;

    Errors(final int errorCode, final String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
