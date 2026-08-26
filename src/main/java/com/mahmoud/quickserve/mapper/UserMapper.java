package com.mahmoud.quickserve.mapper;

import com.mahmoud.quickserve.DTO.CustomerRegisterRequest;
import com.mahmoud.quickserve.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    User toEntity(CustomerRegisterRequest request);
}