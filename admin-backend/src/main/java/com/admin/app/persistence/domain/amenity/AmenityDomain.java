package com.admin.app.persistence.domain.amenity;

import com.admin.app.persistence.domain.amenity.properties.JobDomain;
import com.admin.core.persistence.domain.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_amenities")
public class AmenityDomain extends BaseDomain {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "amenity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JobDomain> jobs;
}
