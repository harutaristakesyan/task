package com.configuration.core.exception;

import com.configuration.core.exception.model.Errors;
import lombok.Getter;

import java.io.Serial;
import java.text.MessageFormat;

@Getter
public class EntityNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7225848227655543560L;

    private final String errorCode;

    public EntityNotFoundException(final Class<?> clazz, final Object id) {
        super(MessageFormat.format(Errors.ENTITY_NOT_FOUND.getErrorMessage(), clazz.getSimpleName(), id));
        this.errorCode = Errors.ENTITY_NOT_FOUND.getErrorCode();
    }
}
