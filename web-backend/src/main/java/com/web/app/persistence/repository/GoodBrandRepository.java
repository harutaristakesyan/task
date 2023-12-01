package com.web.app.persistence.repository;

import com.web.app.persistence.domain.GoodBrandDomain;
import com.web.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GoodBrandRepository extends BaseRepository<GoodBrandDomain, UUID> {
    Optional<GoodBrandDomain> findByName(String name);
}
