package com.devteria.identityservice.mapper;

import com.devteria.identityservice.dto.request.RoleCreationRequest;
import com.devteria.identityservice.dto.response.RoleResponse;
import com.devteria.identityservice.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleCreationRequest request);

    RoleResponse toRoleResponse(Role entity);
}
