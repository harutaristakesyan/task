package com.um.app.service;

import com.um.app.data.InternalUserModel;

public interface InternalUserService {

    InternalUserModel getUserByUsername(String username);
}
