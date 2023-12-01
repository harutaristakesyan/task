package com.um.app.controller;


import com.um.app.data.InternalUserModel;
import com.um.app.service.InternalUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/internal")
public class InternalUmController {

    private final InternalUserService internalUserService;
    
    @GetMapping("/{username}")
    public InternalUserModel getAdminByUsername(@PathVariable final String username) {

        return internalUserService.getUserByUsername(username);
    }

}

