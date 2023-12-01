package com.admin.app.persistence.repository;

import com.admin.core.persistence.domain.BaseDomain;
import com.admin.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BenefitRepository extends BaseRepository<BaseDomain, UUID> {
}
