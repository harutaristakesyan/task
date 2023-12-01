package com.i18n.base.exception;

import java.util.Map;
import java.util.function.Supplier;

public interface ExceptionInterface {

    default Supplier<EntityNotFoundException> notFoundException(final Class<?> clazz, final Object id, final Map<String, String> errorDetails) {
        return () -> new EntityNotFoundException(clazz, id, errorDetails);
    }

}
