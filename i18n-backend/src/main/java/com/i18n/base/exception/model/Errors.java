package com.i18n.base.exception.model;

import lombok.Getter;

@Getter
public enum Errors {
    ENTITY_NOT_FOUND("1", "document.not.found", "Document {0} with id = {1} not found");

    private final String errorCode;

    private final String messageCode;

    private final String errorMessage;


    Errors(final String errorCode, final String messageCode, final String errorMessage) {
        this.errorCode = errorCode;
        this.messageCode = messageCode;
        this.errorMessage = errorMessage;
    }
}
