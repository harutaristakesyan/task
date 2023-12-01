package com.admin.app.persistence.domain.contact.properties;

import com.admin.core.persistence.domain.BaseDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_address")
public class Address extends BaseDomain {

    @Column(name = "name")
    private String name;

}
