package com.BlogApplication.Blog.Repo;

import com.BlogApplication.Blog.Entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<userEntity, Integer> {
}
