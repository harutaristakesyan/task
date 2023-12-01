package com.um.app.persistence.repository;

import com.um.app.persistence.domain.RoleDomain;
import com.um.core.persistence.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends BaseRepository<RoleDomain> {
}
