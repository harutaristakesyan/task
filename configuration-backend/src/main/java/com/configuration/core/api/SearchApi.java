package com.configuration.core.api;

import com.configuration.core.supported.SearchSupported;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;

public interface SearchApi<I, O> extends SearchSupported<I, O> {

    @Override
    @GetMapping
    @Operation(summary = "Search", description = "Search by parameters")
    O search(I searchModel);
}
