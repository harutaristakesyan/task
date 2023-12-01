package com.um.core.api;

import com.um.core.supported.UpdateSupported;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

public interface UpdateApi<ID, I, O> extends UpdateSupported<ID, I, O> {


    @Override
    @PutMapping("/{id}")
    @Operation(summary = "Update a resource", description = "This endpoint update a resource using identifier.")
    O update(@PathVariable ID id, I request);
}
