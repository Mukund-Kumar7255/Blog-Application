package com.BlogApplication.Blog.Service;

import com.BlogApplication.Blog.Entity.userEntity;
import com.BlogApplication.Blog.Exception.ResourceNotFoundException;
import com.BlogApplication.Blog.Payloads.UserDto;
import com.BlogApplication.Blog.Repo.UserRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto user) {
        userEntity userEntity = this.dtoToUser(user);
        userEntity savedUser = this.userRepo.save(userEntity);
        return this.userToDto(savedUser);
    }
    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        userEntity userEntity = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setAbout(userDto.getAbout());
        userEntity updatedUser = this.userRepo.save(userEntity);
        return this.userToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        userEntity user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<userEntity> users=this.userRepo.findAll();
        List<UserDto>userDto=users.stream().map(this::userToDto).toList();
        return userDto;
    }

    @Override
    public void deleteUser(Integer userId) {
        userEntity user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        this.userRepo.delete(user);
    }
    private userEntity dtoToUser(UserDto userDto) {
        userEntity user=this.modelMapper.map(userDto,userEntity.class);
//         user.setId(userDto.getId());
//         user.setName(userDto.getName());
//         user.setEmail(userDto.getEmail());
//         user.setPassword(userDto.getPassword());
//         user.setAbout(userDto.getAbout());
         return user;
    }
    public UserDto userToDto(userEntity user) {
        UserDto userDto=this.modelMapper.map(user,UserDto.class);
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setAbout(user.getAbout());
        return userDto;
    }
}

