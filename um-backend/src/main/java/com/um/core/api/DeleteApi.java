package com.um.core.api;

import com.um.core.supported.DeleteSupported;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface DeleteApi<I, O> extends DeleteSupported<I, O> {

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a resource", description = "This endpoint delete a resource using identifier.")
    O delete(@PathVariable I id);
}
