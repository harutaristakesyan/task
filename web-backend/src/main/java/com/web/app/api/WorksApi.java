package com.web.app.api;

import com.web.core.api.AllApi;
import com.web.core.config.SwagerProperties;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/works")
@Tag(name = SwagerProperties.WORKS_TITLE, description = SwagerProperties.WORKS_DESCRIPTION)
public interface WorksApi extends AllApi<ResponseEntity<?>> {
}
