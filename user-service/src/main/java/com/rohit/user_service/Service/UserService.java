package com.rohit.user_service.Service;

import com.rohit.user_service.Dto.ResponseDto;
import com.rohit.user_service.Entity.User;

public interface UserService {
    User saveUser(User user);

    ResponseDto getUser(Long userId);
}