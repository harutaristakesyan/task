package com.um.app.service;

import com.um.app.data.Applications;
import com.um.core.data.AbstractListResponse;
import com.um.core.data.Void;
import com.um.core.data.BaseSearchCriteria;
import com.um.core.supported.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

public interface RolesService extends DeleteSupported<UUID, Void>,
        AddSupported<RolesService.RoleRequest, Void>,
        GetSupported<UUID, RolesService.RoleResponse>,
        UpdateSupported<UUID, RolesService.RoleRequest, Void>,
        SearchSupported<RolesService.RoleSearchCriteria, AbstractListResponse<RolesService.RoleResponse>> {


    record RoleRequest(String name, String description, Applications application, Set<UUID> permissions) {
    }

    record RoleResponse(UUID id, String name, String description, Applications application, Set<UUID> permissions) {
    }


    @Getter
    @Setter
    @NoArgsConstructor
    class RoleSearchCriteria extends BaseSearchCriteria {
    }
}
