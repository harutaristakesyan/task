package com.file.managemnet.base.services;


import com.file.managemnet.base.exception.ExceptionInterface;

public interface GetSupported<I, O> extends ExceptionInterface {

    O get(I uuid);
}
