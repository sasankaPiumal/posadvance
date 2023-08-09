package com.sasstack.posadvance.service.impl;

import com.sasstack.posadvance.repo.UserRoleRepo;
import com.sasstack.posadvance.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepo userRoleRepo;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepo userRoleRepo) {
        this.userRoleRepo = userRoleRepo;
    }


    @Override
    public void initializeRoles() {

    }
}
