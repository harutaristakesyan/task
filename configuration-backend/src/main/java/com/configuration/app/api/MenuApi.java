package com.configuration.app.api;

import com.configuration.app.service.MenuService;
import com.configuration.app.service.model.MenuSearchCriteria;
import com.configuration.core.api.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/menus")
public interface MenuApi extends GetApi<UUID, ResponseEntity<?>>,
        DeleteApi<UUID, ResponseEntity<?>>,
        SearchApi<MenuSearchCriteria, ResponseEntity<?>>,
        AddApi<MenuService.MenuRequest, ResponseEntity<?>>,
        UpdateApi<UUID, MenuService.MenuRequest, ResponseEntity<?>> {
}
