package com.web.cms.persistence.domain;

import com.web.core.persistence.domain.BaseDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "promotion")
public class PromotionDomain extends BaseDomain {


    @Field(name = "image")
    private String image;

    @Field(name = "text")
    private String text;

    @Field(name = "endDate")
    private LocalDate endDate;
}
