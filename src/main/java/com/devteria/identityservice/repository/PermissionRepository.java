package com.devteria.identityservice.repository;

import com.devteria.identityservice.entity.Permission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, String> {
}
