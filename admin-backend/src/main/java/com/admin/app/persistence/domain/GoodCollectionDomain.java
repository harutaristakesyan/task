package com.admin.app.persistence.domain;

import com.admin.core.persistence.domain.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "t_goods_collections")
public class GoodCollectionDomain extends BaseDomain {

    @Column(name = "route")
    private String route;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private GoodBrandDomain brand;

    @JoinColumn(name = "catalog_id")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private FileDomain catalog;

}
