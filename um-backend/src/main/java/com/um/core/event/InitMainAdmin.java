package com.um.core.event;


import com.um.app.persistence.domain.UserDomain;
import com.um.app.persistence.repository.UserRepository;
import com.um.app.persistence.domain.PermissionDomain;
import com.um.app.persistence.repository.PermissionRepository;
import com.um.app.persistence.domain.RoleDomain;
import com.um.app.persistence.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class InitMainAdmin {

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final PermissionRepository permissionRepository;

    private final PasswordEncoder passwordEncoder;


    @EventListener(ApplicationReadyEvent.class)
    public void initMainAdmin() {
        final var permissions = this.initAdminPermissions();
        final var role = this.initAdminRole(permissions);
        final var userEntity = new UserDomain();
        userEntity.setRoleEntity(role);
        userEntity.setUsername("main_admin");
        userEntity.setFirstName("Main");
        userEntity.setLastName("Admin");
        userEntity.setEmail("main.admin@mail.ru");
        userEntity.setPassword(passwordEncoder.encode("12345678"));

        userRepository.save(userEntity);
    }

    private RoleDomain initAdminRole(final List<PermissionDomain> permissions) {
        final var roleEntity = new RoleDomain();
        roleEntity.setName("MAIN_ADMIN");
        roleEntity.setDescription("Main admin role");
        roleEntity.setPermissions(new HashSet<>(permissions));
        return roleRepository.save(roleEntity);
    }

    private List<PermissionDomain> initAdminPermissions() {
        final Set<PermissionDomain> permissions = new HashSet<>();
        permissions.add(new PermissionDomain("", "", ""));

        return permissionRepository.saveAll(permissions);
    }
}
