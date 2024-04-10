package com.example.ems.controler;

import com.example.ems.dto.UserDto;

import com.example.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired // use for the dependency injection
    private UserService userService;

    @GetMapping("/getUser")
    public List<UserDto>   getUser(){
        return userService.getAllUser();
    }

    @PostMapping("/saveUser")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @PutMapping("/updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto){
        return userService.userUpdate(userDto);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDto userDto){
        return userService.deleteUser(userDto);
    }

    @GetMapping("/getUserByUserId/{userID}")
    public UserDto getUserByUserId(@PathVariable String userID){
        return userService.getUserByUserId(userID);
    }

    @GetMapping("/getUserByUserIdAndAddress/{userID}/{address}")
    public UserDto getUserByUserIdAndAddress(@PathVariable String userID, @PathVariable String address){
        return userService.getUserByUserIdAndAddress(userID, address);
    }



}
