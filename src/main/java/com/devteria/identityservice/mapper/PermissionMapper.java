package com.devteria.identityservice.mapper;

import com.devteria.identityservice.dto.request.PermissionCreationRequest;
import com.devteria.identityservice.dto.response.PermissionResponse;
import com.devteria.identityservice.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionCreationRequest request);
    PermissionResponse toPermissionResponse(Permission entity);
}
