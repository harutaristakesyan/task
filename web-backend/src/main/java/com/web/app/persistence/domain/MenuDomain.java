package com.web.app.persistence.domain;

import com.web.core.persistence.domain.BaseDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "menus")
public class MenuDomain extends BaseDomain {

    @Field(name = "names")
    private Set<TextDomain> names;

    @Field(name = "icon_name")
    private String iconName;

    @Field(name = "route")
    private String route;

    @Field(name = "is_nav_bar")
    private Boolean isNavBar;

    @Field(name = "children")
    private Set<MenuDomain> children;
}
