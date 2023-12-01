package com.web.app.persistence.domain;


import com.web.core.persistence.domain.BaseDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Getter
@Setter
@NoArgsConstructor
public class TextDomain {

    @Field(name = "text")
    private String text;

    @Field(name = "lang_code")
    private String langCode;
}
