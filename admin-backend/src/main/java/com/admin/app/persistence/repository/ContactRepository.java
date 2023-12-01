package com.admin.app.persistence.repository;

import com.admin.app.persistence.domain.contact.ContactDomain;
import com.admin.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContactRepository extends BaseRepository<ContactDomain, UUID> {

    Optional<ContactDomain> findFirstByOrderByCreatedDesc();

}
