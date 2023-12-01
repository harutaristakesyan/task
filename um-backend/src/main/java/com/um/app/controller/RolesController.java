package com.um.app.controller;

import com.um.app.api.RolesApi;
import com.um.app.service.RolesService;
import com.um.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RolesController implements RolesApi {

    private final RolesService rolesService;

    @Override
    public ResponseEntity<?> add(final RolesService.RoleRequest request) {
        return ResponseUtil.created(rolesService.add(request));
    }

    @Override
    public ResponseEntity<?> delete(final UUID id) {
        return ResponseUtil.noContent(rolesService.delete(id));
    }

    @Override
    public ResponseEntity<?> get(final UUID id) {
        return ResponseUtil.ok(rolesService.get(id));
    }

    @Override
    public ResponseEntity<?> search(final RolesService.RoleSearchCriteria searchModel) {
        return ResponseUtil.ok(rolesService.search(searchModel));
    }

    @Override
    public ResponseEntity<?> update(final UUID uuid, final RolesService.RoleRequest request) {
        return ResponseUtil.noContent(rolesService.update(uuid, request));
    }
}
