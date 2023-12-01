package com.um.app.persistence.domain;

import com.um.app.data.Applications;
import com.um.core.persistence.domain.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_roles")
public class RoleDomain extends BaseDomain {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "application")
    @Enumerated(EnumType.STRING)
    private Applications application;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Set<PermissionDomain> permissions;

}
