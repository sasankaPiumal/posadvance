package com.sasstack.posadvance.service;

import com.sasstack.posadvance.dto.request.RequestUserDto;

public interface UserService {
    void createUser(RequestUserDto requestUserDto, String role);
}
