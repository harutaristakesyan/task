package com.web.cms.mapper;

import com.web.cms.persistence.domain.contact.Contact;
import com.web.cms.service.ContactService;
import com.web.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper extends DtoMapper<ContactService.ContactResponse, Contact> {
}
