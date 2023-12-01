package com.um.core.supported;

public interface UpdateSupported<ID, I, O> {

    O update(ID id, I request);
}
