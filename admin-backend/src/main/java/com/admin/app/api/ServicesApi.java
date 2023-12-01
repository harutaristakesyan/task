package com.admin.app.api;

import com.admin.core.api.AllApi;
import com.admin.core.config.SwaggerProperties;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/services")
@Tag(name = SwaggerProperties.SERVICE_TITLE, description = SwaggerProperties.SERVICE_DESCRIPTION)
public interface ServicesApi extends AllApi<ResponseEntity<?>> {
}
