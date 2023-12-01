package com.web.cms.persistence.domain;

import com.web.core.persistence.domain.BaseDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "benefits")
public class BenefitDomain extends BaseDomain {

    @Field(name = "title")
    private String title;

    @Field(name = "description")
    private String description;
}
