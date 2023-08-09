package com.sasstack.posadvance.util.mapper;

import com.sasstack.posadvance.dto.core.UserDto;
import com.sasstack.posadvance.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDto dto);

}
