package com.admin.app.persistence.repository;

import com.admin.app.persistence.domain.PromotionDomain;
import com.admin.app.persistence.domain.contact.ContactDomain;
import com.admin.app.service.PromotionsService;
import com.admin.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PromotionRepository extends BaseRepository<PromotionDomain, UUID> {

}
