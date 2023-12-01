package com.um.core.api;

import com.um.core.supported.AllSupported;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface AllApi<O> extends AllSupported<O> {

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get All resource", description = "Get a list of all resource")
    O all();
}
