package com.budimind.bashapp.repository;

import com.budimind.bashapp.constant.AccountRole;
import com.budimind.bashapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByRole(AccountRole role);
}
