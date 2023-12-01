package com.admin.app.persistence.repository;

import com.admin.app.persistence.domain.WorkDomain;
import com.admin.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkRepository extends BaseRepository<WorkDomain, UUID> {
}
