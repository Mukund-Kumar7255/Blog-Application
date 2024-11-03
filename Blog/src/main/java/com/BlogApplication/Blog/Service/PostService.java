package com.BlogApplication.Blog.Service;

import com.BlogApplication.Blog.Entity.PostEntity;
import com.BlogApplication.Blog.Payloads.PostDto;

import java.util.List;

public interface PostService {
    //create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
    //update
    PostDto updatePost(PostDto postDto,Integer postId);
    //delete
    void deletePost(Integer postId);
    //get All posts
    List<PostDto> getAllPost();
    //get single post
    PostDto getPostById(Integer postId);
    //get all post by category
    List<PostDto>getPostByCategory(Integer categoryId);
    //get all posts by user
    List<PostDto> getPostByUser(Integer userId);
    //searching
    List<PostDto> searchPosts(String keyword);
}
