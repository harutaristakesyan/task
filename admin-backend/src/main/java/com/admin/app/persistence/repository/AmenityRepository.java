package com.admin.app.persistence.repository;

import com.admin.app.persistence.domain.amenity.AmenityDomain;
import com.admin.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AmenityRepository extends BaseRepository<AmenityDomain, UUID> {

}
