package com.web.app.controller;


import com.web.app.api.MenuApi;
import com.web.app.service.MenuService;
import com.web.app.service.model.MenuSearchCriteria;
import com.web.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MenuController implements MenuApi {

    private final MenuService menuService;


    @Override
    public ResponseEntity<?> search(final MenuSearchCriteria searchModel) {
        return ResponseUtil.ok(menuService.search(searchModel));
    }

}
