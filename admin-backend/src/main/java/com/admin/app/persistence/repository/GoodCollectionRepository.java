package com.admin.app.persistence.repository;

import com.admin.app.persistence.domain.GoodCollectionDomain;
import com.admin.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GoodCollectionRepository extends BaseRepository<GoodCollectionDomain, UUID> {

    Optional<GoodCollectionDomain> findByName(String s);
}
