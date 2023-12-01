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
@Document(collection = "questions")
public class QuestionDomain extends BaseDomain {

    @Field(name = "description")
    private String description;
}
