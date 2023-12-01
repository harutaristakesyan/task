package com.um.core.supported;


import com.um.core.exception.ExceptionInterface;

public interface GetSupported<I, O> extends ExceptionInterface {

    O get(I uuid);
}
