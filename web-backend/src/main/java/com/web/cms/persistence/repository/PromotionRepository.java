package com.web.cms.persistence.repository;

import com.web.cms.persistence.domain.PromotionDomain;
import com.web.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PromotionRepository extends BaseRepository<PromotionDomain, UUID> {
}
