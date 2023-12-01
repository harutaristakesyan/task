package com.admin.app.persistence.repository;

import com.admin.app.persistence.domain.GoodBrandDomain;
import com.admin.core.persistence.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GoodBrandRepository extends BaseRepository<GoodBrandDomain, UUID> {
    Optional<GoodBrandDomain> findByName(String name);
}
