package com.admin.core.supported;

import com.admin.core.exception.ExceptionInterface;

public interface GetSupported<I, O> extends ExceptionInterface {

    O get(I uuid);
}
