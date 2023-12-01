package com.web.cms.persistence.repository;

import com.web.core.persistence.domain.BaseDomain;
import com.web.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BenefitRepository extends BaseRepository<BaseDomain, UUID> {
}
