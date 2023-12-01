package com.configuration.app.service;

import com.configuration.app.data.TextDto;
import com.configuration.app.service.model.MenuSearchCriteria;
import com.configuration.core.data.AbstractListResponse;
import com.configuration.core.data.Void;
import com.configuration.core.supported.*;

import java.util.Set;
import java.util.UUID;

public interface MenuService extends AddSupported<MenuService.MenuRequest, Void>,
        DeleteSupported<UUID, Void>,
        GetSupported<UUID, MenuService.MenuResponse>,
        UpdateSupported<UUID, MenuService.MenuRequest, Void>,
        SearchSupported<MenuSearchCriteria, AbstractListResponse<MenuService.MenuSearchResponse>> {

    record MenuRequest(Set<TextDto> names, String iconName, String route, Boolean isNavBar, Set<UUID> children) {

    }

    record MenuResponse(UUID id, Set<TextDto> names, String iconName, String route, Boolean isNavBar,
                        Set<MenuResponse> children) {

    }

    record MenuSearchResponse(UUID id, String name, String iconName, String route, Boolean isNavBar,
                              Set<MenuSearchResponse> children) {

    }
}
