package com.admin.app.service.impl;

import com.admin.app.data.ContactResponse;
import com.admin.app.mapper.ContactMapper;
import com.admin.app.persistence.repository.ContactRepository;
import com.admin.app.service.ContactService;
import com.admin.core.data.AbstractListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactMapper contactMapper;

    private final ContactRepository contactRepository;

    @Override
    @Cacheable("contact")
    public AbstractListResponse<ContactResponse> all() {
//        final <ContactResponse contactResponse = contactRepository.
//                findAll().stream().map(contactMapper::toResponse)

        return null;
    }
}
