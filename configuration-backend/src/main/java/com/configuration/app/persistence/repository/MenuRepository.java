package com.configuration.app.persistence.repository;

import com.configuration.app.persistence.domain.MenuDomain;
import com.configuration.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenuRepository extends BaseRepository<MenuDomain, UUID> {
}
