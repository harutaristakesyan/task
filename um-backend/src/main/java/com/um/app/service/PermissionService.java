package com.um.app.service;

import com.um.app.data.Applications;
import com.um.core.data.AbstractListResponse;
import com.um.core.data.Void;
import com.um.core.data.BaseSearchCriteria;
import com.um.core.supported.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

public interface PermissionService extends
        DeleteSupported<UUID, Void>,
        AddSupported<PermissionService.PermissionRequest, Void>,
        GetSupported<UUID, PermissionService.PermissionResponse>,
        UpdateSupported<UUID, PermissionService.PermissionRequest, Void>,
        SearchSupported<PermissionService.PermissionSearchCriteria, AbstractListResponse<PermissionService.PermissionResponse>> {


    record PermissionRequest(String name, String description, String authority, Applications application) {
    }

    record PermissionResponse(UUID id, String name, String description, String authority, Applications application) {
    }

    @Getter
    @Setter
    @NoArgsConstructor
    class PermissionSearchCriteria extends BaseSearchCriteria {
    }
}
