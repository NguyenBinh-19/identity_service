package com.nguyenbinh.identity_service.mapper;

import com.nguyenbinh.identity_service.dto.request.UserCreationRequest;
import com.nguyenbinh.identity_service.dto.request.UserUpdateRequest;
import com.nguyenbinh.identity_service.dto.response.UserResponse;
import com.nguyenbinh.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest user);
    void updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);

//    @Mapping(source = "firstName", target = "lastName")
//    @Mapping( target = "lastName", ignore = true)
    UserResponse toUserResponse(User user);
    List<UserResponse> toListUserResponses(List<User> users);
}
