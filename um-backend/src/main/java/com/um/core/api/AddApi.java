package com.um.core.api;


import com.um.core.supported.AddSupported;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AddApi<I, O> extends AddSupported<I, O> {

    @Override
    @PostMapping
    @Operation(summary = "Create a new resource", description = "This endpoint creates a new resource.")
    O add(@Parameter(description = "The information for the new tile", required = true) @RequestBody I request);
}
