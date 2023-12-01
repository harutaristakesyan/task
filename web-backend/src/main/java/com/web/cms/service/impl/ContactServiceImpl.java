package com.web.cms.service.impl;


import com.web.cms.mapper.ContactMapper;
import com.web.cms.persistence.repository.ContactRepository;
import com.web.cms.service.ContactService;
import com.web.core.data.AbstractListResponse;
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
