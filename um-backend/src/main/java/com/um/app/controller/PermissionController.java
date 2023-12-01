package com.um.app.controller;

import com.um.app.api.PermissionApi;
import com.um.app.service.PermissionService;
import com.um.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PermissionController implements PermissionApi {

    private final PermissionService permissionService;

    @Override
    public ResponseEntity<?> add(final PermissionService.PermissionRequest request) {
        return ResponseUtil.created(permissionService.add(request));
    }

    @Override
    public ResponseEntity<?> get(final UUID uuid) {
        return ResponseUtil.ok(permissionService.get(uuid));
    }

    @Override
    public ResponseEntity<?> update(final UUID uuid, final PermissionService.PermissionRequest request) {
        return ResponseUtil.noContent(permissionService.update(uuid, request));
    }

    @Override
    public ResponseEntity<?> search(final PermissionService.PermissionSearchCriteria searchModel) {
        return ResponseUtil.ok(permissionService.search(searchModel));
    }

    @Override
    public ResponseEntity<?> delete(final UUID id) {
        return ResponseUtil.noContent(permissionService.delete(id));
    }
}
