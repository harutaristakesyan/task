package com.web.cms.persistence.domain.contact.properties;

import com.web.core.persistence.domain.BaseDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Getter
@Setter
@NoArgsConstructor
@Document(collection = "address")
public class Address extends BaseDomain {

    @Field(name = "name")
    private String name;

}
