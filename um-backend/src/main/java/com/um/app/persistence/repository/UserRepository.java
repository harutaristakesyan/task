package com.um.app.persistence.repository;

import com.um.app.persistence.domain.UserDomain;
import com.um.core.persistence.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends BaseRepository<UserDomain> {

    Optional<UserDomain> findByUsername(String username);
}
