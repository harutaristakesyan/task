package com.um.app.api;

import com.um.app.service.PermissionService;
import com.um.core.api.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/permissions")
public interface PermissionApi extends GetApi<UUID, ResponseEntity<?>>,
        DeleteApi<UUID, ResponseEntity<?>>,
        AddApi<PermissionService.PermissionRequest, ResponseEntity<?>>,
        SearchApi<PermissionService.PermissionSearchCriteria, ResponseEntity<?>>,
        UpdateApi<UUID, PermissionService.PermissionRequest, ResponseEntity<?>> {
}
