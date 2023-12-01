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
@Document(collection = "goods_brands")
public class GoodBrandDomain extends BaseDomain {

    @Field(name = "name")
    private String name;

    @Field(name = "route")
    private String route;

    @Field(name = "country_of_origin")
    private String countryOfOrigin;

    @Field(name = "logo")
    private FileDomain logo;

    @Field(name = "descriptions")
    private Set<TextDomain> descriptions;
}
