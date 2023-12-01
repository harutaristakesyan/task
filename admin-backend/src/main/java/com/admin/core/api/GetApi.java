package com.admin.core.api;

import com.admin.core.supported.GetSupported;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface GetApi<I, O> extends GetSupported<I, O> {

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get a resource", description = "This endpoint get a resource using identifier.")
    O get(@PathVariable I id);
}
