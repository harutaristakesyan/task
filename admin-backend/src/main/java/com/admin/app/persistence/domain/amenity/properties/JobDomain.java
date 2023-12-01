package com.admin.app.persistence.domain.amenity.properties;

import com.admin.app.persistence.domain.amenity.AmenityDomain;
import com.admin.core.persistence.domain.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_jobs")
public class JobDomain extends BaseDomain {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "amenity_id", nullable = false)
    private AmenityDomain amenity;

}
