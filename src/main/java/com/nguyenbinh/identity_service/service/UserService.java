package com.nguyenbinh.identity_service.service;

import com.nguyenbinh.identity_service.dto.request.UserCreationRequest;
import com.nguyenbinh.identity_service.dto.request.UserUpdateRequest;
import com.nguyenbinh.identity_service.dto.response.UserResponse;
import com.nguyenbinh.identity_service.entity.User;
import com.nguyenbinh.identity_service.enums.Role;
import com.nguyenbinh.identity_service.exception.AppException;
import com.nguyenbinh.identity_service.exception.ErrorCode;
import com.nguyenbinh.identity_service.mapper.UserMapper;
import com.nguyenbinh.identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public User createUser(UserCreationRequest request){

        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getUsers(){
        log.info("In method get user");
        return userMapper.toListUserResponses(userRepository.findAll());
    }

    @PostAuthorize("returnObject.username == authentication.name or hasRole('ADMIN')")
    public UserResponse getUser(String id){
        log.info("In method get user by ID");
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse myInfor(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        log.info("Username: {}", username);

        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toUserResponse(user);
    }

    public UserResponse updateUser(String userId,UserUpdateRequest request){
        User user =  userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(user,request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public String deleteUser(String userId){
        //userRepository.deleteById(userId);
        if(!userRepository.findById(userId).isPresent()){
            return "Id not exited!";
        } else {
            userRepository.deleteById(userId);
            return "Delete succesful";
        }
    }
}
