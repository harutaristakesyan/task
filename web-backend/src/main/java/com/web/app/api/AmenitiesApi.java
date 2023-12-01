package com.web.app.api;

import com.web.core.api.AllApi;
import com.web.core.config.SwagerProperties;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/amenities")
@Tag(name = SwagerProperties.SERVICE_TITLE, description = SwagerProperties.SERVICE_DESCRIPTION)
public interface AmenitiesApi extends AllApi<ResponseEntity<?>> {
}
