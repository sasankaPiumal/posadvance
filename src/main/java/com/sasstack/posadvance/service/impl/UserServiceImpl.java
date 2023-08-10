package com.sasstack.posadvance.service.impl;

import com.sasstack.posadvance.dto.core.UserDto;
import com.sasstack.posadvance.dto.request.RequestUserDto;
import com.sasstack.posadvance.entity.User;
import com.sasstack.posadvance.entity.UserRoleHasUser;
import com.sasstack.posadvance.exception.DuplicateEntryException;
import com.sasstack.posadvance.exception.EntryNotFoundException;
import com.sasstack.posadvance.repo.UserRepo;
import com.sasstack.posadvance.repo.UserRoleHasUserRepo;
import com.sasstack.posadvance.repo.UserRoleRepo;
import com.sasstack.posadvance.service.UserService;
import com.sasstack.posadvance.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final UserRoleRepo userRoleRepo;

    private final UserMapper userMapper;

    private final UserRoleHasUserRepo userRoleHasUserRepo;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserRoleRepo userRoleRepo, UserMapper userMapper, UserRoleHasUserRepo userRoleHasUserRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.userRoleRepo = userRoleRepo;
        this.userMapper = userMapper;
        this.userRoleHasUserRepo = userRoleHasUserRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(RequestUserDto requestUserDto, String role) {
        var selectedUserRole = userRoleRepo.findByRoleNameEquals(role);
        if (selectedUserRole.isEmpty()) {
            throw new EntryNotFoundException("User not found!");
        }
        {
            Optional<User> selectedUserByEmail = userRepo.findUserByEmail(requestUserDto.getEmail());
            if (selectedUserByEmail.isPresent()) {
                throw new DuplicateEntryException("User Email Already Exists!");
            }
            UserDto dto = new UserDto(
                    String.valueOf(new Random().nextInt(1000)),
                    requestUserDto.getEmail(),
                    requestUserDto.getFullName(),
                    passwordEncoder.encode(requestUserDto.getPassword())
            );
            User user = userMapper.toUser(dto);
            userRepo.save(user);
            UserRoleHasUser userRoleHasUser = new UserRoleHasUser();
            userRoleHasUser.setUser(user);
            userRoleHasUser.setUserRole(selectedUserRole.get());
            userRoleHasUserRepo.save(userRoleHasUser);


        }

    }


}
