package com.BlogApplication.Blog.Repo;

import com.BlogApplication.Blog.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<CommentEntity,Integer> {

}
