package com.web.cms.persistence.repository;

import com.web.cms.persistence.domain.contact.Contact;
import com.web.core.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContactRepository extends BaseRepository<Contact, UUID> {

    Optional<Contact> findFirstByOrderByCreatedDesc();

}
