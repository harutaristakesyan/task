package com.web.app.service;

import com.web.app.service.model.MenuSearchCriteria;
import com.web.core.data.AbstractListResponse;
import com.web.core.data.Void;
import com.web.core.supported.AddSupported;
import com.web.core.supported.DeleteSupported;
import com.web.core.supported.SearchSupported;
import kafka.models.menu.MenuKafkaModel;

import java.util.Set;
import java.util.UUID;

public interface MenuService extends AddSupported<MenuKafkaModel, Void>,
        DeleteSupported<UUID, Void>,
        SearchSupported<MenuSearchCriteria, AbstractListResponse<MenuService.MenuSearchResponse>> {

    record MenuSearchResponse(String name, String iconName, String route, Boolean isNavBar,
                              Set<MenuSearchResponse> children) {

    }
}
