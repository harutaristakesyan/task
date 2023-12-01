package com.um.core.exception;

import java.util.Map;
import java.util.function.Supplier;

public interface ExceptionInterface {

    default Supplier<EntityNotFoundException> entityNotFoundException(final Class<?> clazz, final Object id, Map<String, String> errorDetails) {
        return () -> new EntityNotFoundException(clazz, id, errorDetails);
    }

}
