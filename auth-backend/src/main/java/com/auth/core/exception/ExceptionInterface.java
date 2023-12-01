package com.auth.core.exception;

import java.util.function.Supplier;

public interface ExceptionInterface {

    default Supplier<EntityNotFoundException> entityNotFoundException(final Class<?> clazz, final Object id) {
        return () -> new EntityNotFoundException(clazz, id);
    }

}
