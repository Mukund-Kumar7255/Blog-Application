package com.BlogApplication.Blog.Payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;

//    @Column(name = "user_name",nullable = false,length = 100)
    @NotNull
    private String name;
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String about;
}
