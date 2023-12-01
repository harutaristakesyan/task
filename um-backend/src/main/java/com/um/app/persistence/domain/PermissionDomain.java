package com.um.app.persistence.domain;

import com.um.app.data.Applications;
import com.um.core.persistence.domain.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_permissions")
public class PermissionDomain extends BaseDomain {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "authority")
    private String authority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleDomain role;

    @Column(name = "application")
    @Enumerated(EnumType.STRING)
    private Applications application;

    public PermissionDomain(final String name, final String description, final String authority) {
        this.name = name;
        this.authority = authority;
        this.description = description;
    }
}
