package com.admin.app.persistence.repository;

import com.admin.app.persistence.domain.GoodCategoryDomain;
import com.admin.core.persistence.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GoodCategoryRepository extends BaseRepository<GoodCategoryDomain, UUID> {

    @Query("SELECT u FROM GoodCategoryDomain u JOIN u.names n WHERE n.text = :name")
    Optional<GoodCategoryDomain> findByNames(final String name);
}
