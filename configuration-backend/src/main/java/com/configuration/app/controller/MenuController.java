package com.configuration.app.controller;

import com.configuration.app.api.MenuApi;
import com.configuration.app.service.MenuService;
import com.configuration.app.service.model.MenuSearchCriteria;
import com.configuration.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MenuController implements MenuApi {

    private final MenuService menuService;

    @Override
    public ResponseEntity<?> add(final MenuService.MenuRequest request) {
        return ResponseUtil.created(menuService.add(request));
    }

    @Override
    public ResponseEntity<?> delete(final UUID id) {
        return ResponseUtil.noContent(menuService.delete(id));
    }

    @Override
    public ResponseEntity<?> get(final UUID id) {
        return ResponseUtil.ok(menuService.get(id));
    }

    @Override
    public ResponseEntity<?> search(final MenuSearchCriteria searchModel) {
        return ResponseUtil.ok(menuService.search(searchModel));
    }

    @Override
    public ResponseEntity<?> update(final UUID id, final MenuService.MenuRequest request) {
        return ResponseUtil.noContent(menuService.update(id, request));
    }
}
