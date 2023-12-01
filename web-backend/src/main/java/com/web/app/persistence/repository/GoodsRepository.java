package com.web.app.persistence.repository;


import com.web.app.persistence.domain.GoodDomain;
import com.web.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GoodsRepository extends BaseRepository<GoodDomain, UUID> {
}
