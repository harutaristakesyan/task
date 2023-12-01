package com.web.app.persistence.repository;

import com.web.app.persistence.domain.GoodCategoryDomain;
import com.web.core.persistence.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GoodCategoryRepository extends BaseRepository<GoodCategoryDomain, UUID> {

    Page<GoodCategoryDomain> findAllByNamesLike(final String name, Pageable pageable);
}
