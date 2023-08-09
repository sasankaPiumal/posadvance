package com.sasstack.posadvance.repo;

import com.sasstack.posadvance.entity.UserRoleHasUserKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRoleHasUser extends JpaRepository<UserRoleHasUser,String> {
}
