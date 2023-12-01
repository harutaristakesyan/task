package com.admin.app.mapper;

import com.admin.app.data.ContactResponse;
import com.admin.app.persistence.domain.contact.ContactDomain;
import com.admin.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper extends DtoMapper<ContactResponse, ContactDomain> {
}
