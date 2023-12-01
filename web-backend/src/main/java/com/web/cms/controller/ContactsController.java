package com.web.cms.controller;

import com.web.cms.api.ContactsApi;
import com.web.cms.service.ContactService;
import com.web.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContactsController implements ContactsApi {

    private final ContactService contactService;

    @Override
    public ResponseEntity<?> all() {
        return ResponseUtil.ok(contactService.all());
    }
}
