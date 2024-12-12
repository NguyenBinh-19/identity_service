package com.nguyenbinh.identity_service.controller;

import com.nguyenbinh.identity_service.dto.request.ApiResponse;
import com.nguyenbinh.identity_service.dto.request.UserCreationRequest;
import com.nguyenbinh.identity_service.dto.request.UserUpdateRequest;
import com.nguyenbinh.identity_service.dto.response.UserResponse;
import com.nguyenbinh.identity_service.entity.User;
import com.nguyenbinh.identity_service.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {
    UserService userService;

    //create user
    @PostMapping
    ApiResponse<User>  createUser(@RequestBody @Valid UserCreationRequest request) {

        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    //get all user
    @GetMapping
    List<UserResponse> getUsers(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority
                -> log.info("GrantedAuthority: {}", grantedAuthority));

        return userService.getUsers();
    }

    //find user by id
    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable String userId){
        return userService.getUser(userId);
    }

    //update user
    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request){
       return userService.updateUser(userId, request);
    }

    //delete user
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        return userService.deleteUser(userId);
    }

    //get my infor
    @GetMapping("/myinfor")
    ApiResponse<UserResponse> myinfor(){
        return ApiResponse.<UserResponse>builder()
                .result(userService.myInfor())
                .build();
    }
}
