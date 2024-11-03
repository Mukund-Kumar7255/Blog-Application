package com.BlogApplication.Blog.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class userEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "user_name",nullable = false,length = 100)
    private String name;
    private String email;
    private String password;
    private String about;

    @OneToMany(mappedBy="user",cascade = CascadeType.ALL)
    private List<PostEntity> posts=new ArrayList<>();
}
