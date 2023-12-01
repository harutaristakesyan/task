package com.admin.app.persistence.domain;

import com.admin.core.persistence.domain.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "t_goods_categories")
public class GoodCategoryDomain extends BaseDomain {

    @Column(name = "route")
    private String route;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "t_goods_categories_names", joinColumns = @JoinColumn(name = "good_category_id"), inverseJoinColumns = @JoinColumn(name = "name_id"))
    private Set<TextDomain> names;
}
