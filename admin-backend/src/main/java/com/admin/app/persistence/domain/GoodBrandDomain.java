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
@Table(name = "t_goods_brands")
public class GoodBrandDomain extends BaseDomain {

    @Column(name = "name")
    private String name;

    @Column(name = "route")
    private String route;

    @Column(name = "country_of_origin")
    private String countryOfOrigin;

    @JoinColumn(name = "logo_id")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private FileDomain logo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "t_goods_brands_descriptions", joinColumns = @JoinColumn(name = "good_brand_id"), inverseJoinColumns = @JoinColumn(name = "description_id"))
    private Set<TextDomain> descriptions;
}
