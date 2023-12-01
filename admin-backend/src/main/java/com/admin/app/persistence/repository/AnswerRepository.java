package com.admin.app.persistence.repository;

import com.admin.app.persistence.domain.AnswerDomain;
import com.admin.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnswerRepository extends BaseRepository<AnswerDomain, UUID> {
}
