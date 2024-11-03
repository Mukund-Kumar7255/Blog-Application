package com.BlogApplication.Blog.Repo;

import com.BlogApplication.Blog.Entity.Category;
import com.BlogApplication.Blog.Entity.PostEntity;
import com.BlogApplication.Blog.Entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<PostEntity,Integer> {
    List<PostEntity> findByCategory(Category cat);

    List<PostEntity> findByUser(userEntity user);

    List<PostEntity> findByTitleContaining(String keyword);
//    List<PostEntity> findByuserEntity(userEntity userEntity);
//   List<Category> findByCategory(Category category);

}