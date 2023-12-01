package com.configuration.core.supported;


import com.configuration.core.exception.ExceptionInterface;

public interface GetSupported<I, O> extends ExceptionInterface {

    O get(I uuid);
}
