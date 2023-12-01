package com.web.app.persistence.domain;


import com.web.core.persistence.domain.BaseDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "goods")
public class GoodDomain extends BaseDomain {

    @Field(name = "price")
    private BigDecimal price;

    @Field(name = "sale_price")
    private BigDecimal salePrice;

    @Field(name = "discount")
    private BigDecimal discount;

    @Field(name = "warranty")
    private BigDecimal warranty;

    @Field(name = "color")
    private String color;

    @Field(name = "finish")
    private String finish;

    @Field(name = "material")
    private String material;

    @Field(name = "usage")
    private String usage;

    @Field(name = "area")
    private String area;

    @Field(name = "category")
    private GoodCategoryDomain category;

    @Field(name = "vendorCode")
    private String vendorCode;

    @Field(name = "images")
    private Set<FileDomain> images;

    @Field(name = "brand")
    private GoodBrandDomain brand;

    @Field(name = "catalog")
    private FileDomain catalog;

    @Field(name = "volume")
    private String volume;

    @Field(name = "availability")
    private Boolean availability;

    @Field(name = "titles")
    private Set<TextDomain> titles;

    @Field(name = "descriptions")
    private Set<TextDomain> descriptions;
}

