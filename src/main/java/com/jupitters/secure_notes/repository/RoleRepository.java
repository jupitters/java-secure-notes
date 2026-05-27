package com.jupitters.secure_notes.repository;

import com.jupitters.secure_notes.models.AppRole;
import com.jupitters.secure_notes.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
