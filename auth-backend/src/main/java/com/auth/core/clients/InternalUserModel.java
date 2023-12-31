package com.auth.core.clients;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternalUserModel {

    private String username;

    private String password;

    private List<String> permissions;
}
