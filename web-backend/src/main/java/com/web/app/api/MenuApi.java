package com.web.app.api;

import com.web.app.service.model.MenuSearchCriteria;
import com.web.core.api.SearchApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/menus")
public interface MenuApi extends SearchApi<MenuSearchCriteria, ResponseEntity<?>> {
}
