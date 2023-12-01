package com.web.app.persistence.repository;

import com.web.app.persistence.domain.ServiceDomain;
import com.web.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ServiceRepository extends BaseRepository<ServiceDomain, UUID> {

    List<ServiceDomain> findAllByOrderByPriceAsc();

}
