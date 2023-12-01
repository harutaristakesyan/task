package com.web.core.supported;


import com.web.core.exception.ExceptionInterface;

public interface GetSupported<I, O> extends ExceptionInterface {

    O get(I uuid);
}
