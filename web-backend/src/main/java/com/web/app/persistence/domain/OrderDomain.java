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
@Document(collection = "orders")
public class OrderDomain extends BaseDomain {

    @Field(name = "name")
    private String name;

    @Field(name = "phone_number")
    private String phoneNumber;

}
