package com.web.app.persistence.repository;

import com.web.app.persistence.domain.amenity.AmenityDomain;
import com.web.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AmenityRepository extends BaseRepository<AmenityDomain, UUID> {

}
