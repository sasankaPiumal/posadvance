package com.sasstack.posadvance.service.impl;

import com.sasstack.posadvance.entity.UserRole;
import com.sasstack.posadvance.repo.UserRoleRepo;
import com.sasstack.posadvance.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepo userRoleRepo;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepo userRoleRepo) {
        this.userRoleRepo = userRoleRepo;
    }


    @Override
    public void initializeRoles() {
        List<UserRole> list = userRoleRepo.findAll();
        if (list.isEmpty()){
            UserRole admin = new UserRole("POS-R-1","ADMIN","",null);
            UserRole user = new UserRole("POS-R-2","USER","",null);
            UserRole manager = new UserRole("POS-R-3","MANAGER","",null);

            userRoleRepo.saveAll(List.of(admin,user,manager));
        }


    }
}
