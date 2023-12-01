package com.web.app.persistence.repository;

import com.web.app.persistence.domain.WorkDomain;
import com.web.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkRepository extends BaseRepository<WorkDomain, UUID> {
}
