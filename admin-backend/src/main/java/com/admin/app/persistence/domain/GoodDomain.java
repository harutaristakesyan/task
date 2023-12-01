package com.admin.app.persistence.domain;

import com.admin.core.persistence.domain.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "t_goods")
public class GoodDomain extends BaseDomain {

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @ManyToOne
    @JoinColumn(name = "promotion_id", nullable = false)
    private PromotionDomain promotion;

    @Column(name = "warranty")
    private BigDecimal warranty;

    @Column(name = "color")
    private String color;

    @Column(name = "finish")
    private String finish;

    @Column(name = "material")
    private String material;

    @Column(name = "usage")
    private String usage;

    @Column(name = "area")
    private String area;

    @Column(name = "vendor_code")
    private String vendorCode;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private GoodCategoryDomain category;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "t_goods_images", joinColumns = @JoinColumn(name = "good_id"), inverseJoinColumns = @JoinColumn(name = "file_id"))
    private Set<FileDomain> images;

    @ManyToOne
    @JoinColumn(name = "collection_id", nullable = false)
    private GoodCollectionDomain collection;

    @Column(name = "volume")
    private String volume;

    @Column(name = "availability")
    private Boolean availability;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "t_goods_titles", joinColumns = @JoinColumn(name = "good_id"), inverseJoinColumns = @JoinColumn(name = "title_id"))
    private Set<TextDomain> titles;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "t_goods_descriptions", joinColumns = @JoinColumn(name = "good_id"), inverseJoinColumns = @JoinColumn(name = "description_id"))
    private Set<TextDomain> descriptions;
}

