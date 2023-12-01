package com.um.app.api;

import com.um.app.service.RolesService;
import com.um.core.api.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/roles")
public interface RolesApi extends GetApi<UUID, ResponseEntity<?>>,
        DeleteApi<UUID, ResponseEntity<?>>,
        SearchApi<RolesService.RoleSearchCriteria, ResponseEntity<?>>,
        AddApi<RolesService.RoleRequest, ResponseEntity<?>>,
        UpdateApi<UUID, RolesService.RoleRequest, ResponseEntity<?>> {

}
