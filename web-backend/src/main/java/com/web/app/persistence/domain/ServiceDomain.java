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
@Document(collection = "services")
public class ServiceDomain extends BaseDomain {

    @Field(name = "name")
    private String name;

    @Field(name = "price")
    private Integer price;
}
