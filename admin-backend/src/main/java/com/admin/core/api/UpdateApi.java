package com.admin.core.api;

import com.admin.core.supported.UpdateSupported;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UpdateApi<ID, I, O> extends UpdateSupported<ID, I, O> {


    @Override
    @PutMapping("/{id}")
    @Operation(summary = "Update a resource", description = "This endpoint update a resource using identifier.")
    O update(@PathVariable ID id, @RequestBody I request);
}
