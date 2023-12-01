package com.web.cms.persistence.domain.contact;

import com.web.cms.persistence.domain.contact.properties.Address;
import com.web.core.persistence.domain.BaseDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Document(collection = "contacts")
public class Contact extends BaseDomain {

    @Field(name = "instagram_url")
    private String instagramUrl;

    @Field(name = "whatsapp_url")
    private String whatsappUrl;

    @Field(name = "viber_url")
    private String viberUrl;

    @Field(name = "mail")
    private String mail;

    @Field(name = "phone_number")
    private String phoneNumber;

    @Field(name = "free_phone_number")
    private String freePhoneNumber;

    @DBRef(db = "address")
    private Set<Address> address;
}
