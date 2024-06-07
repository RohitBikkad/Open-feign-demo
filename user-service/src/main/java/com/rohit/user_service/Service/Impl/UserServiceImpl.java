package com.rohit.user_service.Service.Impl;

import com.rohit.user_service.Dto.DepartmentDto;
import com.rohit.user_service.Dto.ResponseDto;
import com.rohit.user_service.Dto.UserDto;
import com.rohit.user_service.Entity.User;
import com.rohit.user_service.FeignClient.APIClient;
import com.rohit.user_service.Repository.UserRepository;
import com.rohit.user_service.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private APIClient apiClient;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(Long userId) {

        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();
        UserDto userDto = mapToUser(user);

        DepartmentDto departmentDto = apiClient.getDepartmentById(Long.valueOf(user.getDepartmentId()));
        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }

    private UserDto mapToUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}