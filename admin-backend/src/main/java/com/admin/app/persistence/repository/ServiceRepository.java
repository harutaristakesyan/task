package com.admin.app.persistence.repository;

import com.admin.app.persistence.domain.ServiceDomain;
import com.admin.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ServiceRepository extends BaseRepository<ServiceDomain, UUID> {

    List<ServiceDomain> findAllByOrderByPriceAsc();

}
