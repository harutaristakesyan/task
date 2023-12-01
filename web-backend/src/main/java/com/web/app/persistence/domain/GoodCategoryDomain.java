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
@Document(collection = "goods_categories")
public class GoodCategoryDomain extends BaseDomain {

    @Field(name = "route")
    private String route;

    @Field(name = "names")
    private Set<TextDomain> names;
}
