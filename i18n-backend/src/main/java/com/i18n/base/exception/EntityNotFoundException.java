package com.i18n.base.exception;

import com.i18n.base.exception.model.Errors;
import lombok.Getter;

import java.io.Serial;
import java.text.MessageFormat;
import java.util.Map;

@Getter
public class EntityNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7225848227655543560L;

    private final String errorCode;

    private final String messageCode;

    private final Map<String, String> errorDetails;

    public EntityNotFoundException(final Class<?> clazz, final Object id, Map<String, String> errorDetails) {
        super(MessageFormat.format(Errors.ENTITY_NOT_FOUND.getErrorMessage(), clazz.getSimpleName(), id));
        this.errorDetails = errorDetails;
        this.errorCode = Errors.ENTITY_NOT_FOUND.getErrorCode();
        this.messageCode = Errors.ENTITY_NOT_FOUND.getMessageCode();
    }
}
