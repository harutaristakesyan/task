package com.i18n.base.services;

import com.i18n.base.exception.ExceptionInterface;

public interface GetSupported<I, O> extends ExceptionInterface {

    O get(I uuid);
}
