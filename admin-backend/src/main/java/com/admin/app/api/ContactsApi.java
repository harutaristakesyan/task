package com.admin.app.api;

import com.admin.core.api.AllApi;
import com.admin.core.config.SwaggerProperties;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/contacts")
@Tag(name = SwaggerProperties.CONTACTS_TITLE, description = SwaggerProperties.CONTACTS_DESCRIPTION)
public interface ContactsApi extends AllApi<ResponseEntity<?>> {
}
