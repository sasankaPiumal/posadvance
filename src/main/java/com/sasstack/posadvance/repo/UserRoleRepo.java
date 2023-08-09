package com.sasstack.posadvance.repo;

import com.sasstack.posadvance.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRoleRepo extends JpaRepository<UserRole,String> {

    public Optional<UserRole> findByRoleNameEquals(String role);
}
