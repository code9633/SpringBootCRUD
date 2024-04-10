package com.example.ems.service;

import com.example.ems.dto.UserDto;
import com.example.ems.entity.User;
import com.example.ems.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    // Create User
    public UserDto saveUser(UserDto userDto){
        userRepo.save(modelMapper.map(userDto , User.class));
        return userDto;
    }

    // Read All the User
    public List<UserDto> getAllUser(){
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDto>>(){}.getType());
    }

    // Update the particular user
    public UserDto userUpdate(UserDto userDto){
        userRepo.save(modelMapper.map(userDto, User.class));
        return userDto;
    }

    // Delete the user
    public boolean deleteUser(UserDto userDto){
        userRepo.delete(modelMapper.map(userDto, User.class));
        return true;
    }

    // user id > user Details
    // select * from user where id = 2

    public UserDto getUserByUserId(String userId){
        User user = userRepo.getUserByUserId(userId); // pass the data to user Entity
        return modelMapper.map(user, UserDto.class);
    }

    //user id + address > user Details
    //select * from user where id =2 and address = "Colombo"

    public UserDto getUserByUserIdAndAddress(String userId, String address){
        User user = userRepo.getUserByUserIDAndAddress(userId, address);
        return modelMapper.map(user, UserDto.class);
    }

}
