package com.admin.app.controller;

import com.admin.app.api.ContactsApi;
import com.admin.app.service.ContactService;
import com.admin.core.util.ResponseUtil;
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
