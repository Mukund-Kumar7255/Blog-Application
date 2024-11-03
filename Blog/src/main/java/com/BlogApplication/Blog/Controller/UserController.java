package com.BlogApplication.Blog.Controller;

import com.BlogApplication.Blog.Payloads.UserDto;
import com.BlogApplication.Blog.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
//@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
    {
        UserDto CreateUserDto=this.userService.createUser(userDto);
       return new ResponseEntity<>(CreateUserDto, HttpStatus.CREATED);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer uId)
    {
        UserDto updatedUser=this.userService.updateUser(userDto, uId);
        return ok(updatedUser);
    }
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId)
    {
        this.userService.deleteUser(userId);
//        return ResponseEntity.ok(Map.of("message","User deleted successfully"));
    }
    @GetMapping("/users")
    public  ResponseEntity<List<UserDto>>getAllUsers()
    {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer userId)
    {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
