package com.admin.app.persistence.domain.contact;

import com.admin.app.persistence.domain.contact.properties.Address;
import com.admin.core.persistence.domain.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "t_contacts")
public class ContactDomain extends BaseDomain {

    @Column(name = "instagram_url")
    private String instagramUrl;

    @Column(name = "whatsapp_url")
    private String whatsappUrl;

    @Column(name = "viber_url")
    private String viberUrl;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "free_phone_number")
    private String freePhoneNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "t_contacts_address",
            joinColumns = {@JoinColumn(name = "contact_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")}
    )
    private Set<Address> address;
}
