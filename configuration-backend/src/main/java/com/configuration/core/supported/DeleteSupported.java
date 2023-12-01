package com.configuration.core.supported;

public interface DeleteSupported<I, O> {

    O delete(I uuid);
}
