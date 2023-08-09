package com.sasstack.posadvance.service.impl;

import com.sasstack.posadvance.dto.request.RequestUserDto;
import com.sasstack.posadvance.repo.UserRepo;
import com.sasstack.posadvance.repo.UserRoleRepo;
import com.sasstack.posadvance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    }


}
