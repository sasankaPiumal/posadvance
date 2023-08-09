package com.sasstack.posadvance.service.impl;

import com.sasstack.posadvance.dto.core.UserDto;
import com.sasstack.posadvance.dto.request.RequestUserDto;
import com.sasstack.posadvance.entity.User;
import com.sasstack.posadvance.exception.DuplicateEntryException;
import com.sasstack.posadvance.exception.EntryNotFoundException;
import com.sasstack.posadvance.repo.UserRepo;
import com.sasstack.posadvance.repo.UserRoleRepo;
import com.sasstack.posadvance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final UserRoleRepo userRoleRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserRoleRepo userRoleRepo) {
        this.userRepo = userRepo;
        this.userRoleRepo = userRoleRepo;
    }

    @Override
    public void createUser(RequestUserDto requestUserDto, String role) {
        var selectedUserRole = userRoleRepo.findByRoleNameEquals(role);
        if (selectedUserRole.isEmpty()) {
            throw new EntryNotFoundException("User not found!");
        }
        {

            Optional<User> userByEmail = userRepo.findUserByEmail(requestUserDto.getEmail());
            if (userByEmail.isPresent()) {
                throw new DuplicateEntryException("User Email Already Exists!");
            }
            UserDto dto = new UserDto(
                    String.valueOf(new Random().nextInt(1000)),
                    requestUserDto.getEmail(),
                    requestUserDto.getFullName(),
                    requestUserDto.getPassword());
        }

    }


}
