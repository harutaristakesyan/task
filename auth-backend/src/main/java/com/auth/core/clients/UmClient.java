package com.auth.core.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "um",path = "/api/um")
public interface UmClient {

    @GetMapping("/internal/{username}")
    InternalUserModel findAdminByUsername(@PathVariable String username);

}
