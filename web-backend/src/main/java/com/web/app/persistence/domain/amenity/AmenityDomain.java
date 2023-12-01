package com.web.app.persistence.domain.amenity;


import com.web.app.persistence.domain.amenity.properties.JobDomain;
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
@Document(collection = "amenities")
public class AmenityDomain extends BaseDomain {

    @Field(name = "name")
    private String name;

    private Set<JobDomain> jobs;
}
