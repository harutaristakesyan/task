package com.admin.app.persistence.domain;

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
@Table(name = "t_services")
public class ServiceDomain extends BaseDomain {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;
}
