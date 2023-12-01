package com.web.cms.persistence.repository;

import com.web.cms.persistence.domain.AnswerDomain;
import com.web.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnswerRepository extends BaseRepository<AnswerDomain, UUID> {
}
