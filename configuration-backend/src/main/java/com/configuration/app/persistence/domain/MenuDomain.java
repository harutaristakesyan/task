package com.configuration.app.persistence.domain;

import com.configuration.core.persistence.domain.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "t_menus")
public class MenuDomain extends BaseDomain {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "t_menu_names", joinColumns = @JoinColumn(name = "menu_id"), inverseJoinColumns = @JoinColumn(name = "name_id"))
    private Set<TextDomain> names;

    @Column(name = "icon_name")
    private String iconName;

    @Column(name = "route")
    private String route;

    @Column(name = "is_nav_bar")
    private Boolean isNavBar;

    @OneToMany
    @JoinTable(name = "t_menu_children", joinColumns = @JoinColumn(name = "menu_id"), inverseJoinColumns = @JoinColumn(name = "child_id"))
    private Set<MenuDomain> children;
}
