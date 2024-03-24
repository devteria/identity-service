package com.devteria.identityservice.service;

import com.devteria.identityservice.dto.request.PermissionCreationRequest;
import com.devteria.identityservice.dto.response.PermissionResponse;
import com.devteria.identityservice.entity.Permission;
import com.devteria.identityservice.mapper.PermissionMapper;
import com.devteria.identityservice.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionCreationRequest request){
        Permission permission = permissionMapper.toPermission(request);
        return permissionMapper.toPermissionResponse(
                permissionRepository.save(permission));
    }

    public List<PermissionResponse> getAll(){
        var permissions = permissionRepository.findAll();
        List<PermissionResponse> permissionResponses = new ArrayList<>();

        permissions.forEach(permission ->
                permissionResponses.add(
                        permissionMapper.toPermissionResponse(permission)));

        return permissionResponses;
    }

    public void delete(String permission){
        permissionRepository.deleteById(permission);
    }
}
