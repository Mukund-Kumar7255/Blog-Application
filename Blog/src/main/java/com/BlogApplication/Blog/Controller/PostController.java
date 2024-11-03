package com.BlogApplication.Blog.Controller;

import com.BlogApplication.Blog.Payloads.PostDto;
import com.BlogApplication.Blog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;
    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId)
    {
        PostDto createPost=this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }
    //Get By User
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId)
    {
        List<PostDto> posts=this.postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }
    //Get By Category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId)
    {
        List<PostDto> posts=this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }
    //Get All posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost()
    {
        List<PostDto> posts=this.postService.getAllPost();
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }
    //Get post details by id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId)
    {
        PostDto postDto=this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
    }
    @DeleteMapping("/post/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer postId) {
        this.postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/post/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId) {
        PostDto updatedPost = this.postService.updatePost(postDto,postId);
        return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);
    }
    //search
    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPosts(@PathVariable("keywords") String keywords)
    {
        List<PostDto> posts=this.postService.searchPosts(keywords);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }
}
