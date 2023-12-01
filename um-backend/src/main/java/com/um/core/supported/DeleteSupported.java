package com.um.core.supported;

public interface DeleteSupported<I, O> {

    O delete(I uuid);
}
