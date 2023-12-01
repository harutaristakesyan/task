package com.web.cms.api;

import com.web.core.api.AllApi;
import com.web.core.config.SwagerProperties;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/contacts")
@Tag(name = SwagerProperties.CONTACTS_TITLE, description = SwagerProperties.CONTACTS_DESCRIPTION)
public interface ContactsApi extends AllApi<ResponseEntity<?>> {
}
