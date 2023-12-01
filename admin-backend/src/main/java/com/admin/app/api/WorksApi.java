package com.admin.app.api;

import com.admin.core.api.AllApi;
import com.admin.core.config.SwaggerProperties;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/works")
@Tag(name = SwaggerProperties.WORKS_TITLE, description = SwaggerProperties.WORKS_DESCRIPTION)
public interface WorksApi extends AllApi<ResponseEntity<?>> {

}
