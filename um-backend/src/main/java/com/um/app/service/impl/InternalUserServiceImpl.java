package com.um.app.service.impl;

import com.um.app.persistence.domain.PermissionDomain;
import com.um.app.persistence.domain.UserDomain;
import com.um.app.persistence.repository.UserRepository;
import com.um.app.data.InternalUserModel;
import com.um.app.service.InternalUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InternalUserServiceImpl implements InternalUserService {


    private final UserRepository userRepository;


    @Override
    public InternalUserModel getUserByUsername(final String username) {
        var user = userRepository.findByUsername(username).orElse(new UserDomain());
        return new InternalUserModel(user.getUsername(), user.getPassword(), user.getRoleEntity().getPermissions()
                .stream().map(PermissionDomain::getName).collect(Collectors.toList()));
    }
}

