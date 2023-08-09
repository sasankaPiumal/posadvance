package com.sasstack.posadvance.repo;

import com.sasstack.posadvance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User,String> {
    public Optional<User> findUserByEmail(String email);
}
