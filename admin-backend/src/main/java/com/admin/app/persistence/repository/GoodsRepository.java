package com.admin.app.persistence.repository;

import com.admin.app.persistence.domain.GoodDomain;
import com.admin.core.persistence.repository.BaseRepository;

import java.util.UUID;

public interface GoodsRepository extends BaseRepository<GoodDomain, UUID> {
}
