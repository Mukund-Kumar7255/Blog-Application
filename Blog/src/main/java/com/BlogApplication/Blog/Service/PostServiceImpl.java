package com.BlogApplication.Blog.Service;

import com.BlogApplication.Blog.Entity.Category;
import com.BlogApplication.Blog.Entity.PostEntity;
import com.BlogApplication.Blog.Entity.userEntity;
import com.BlogApplication.Blog.Exception.ResourceNotFoundException;
import com.BlogApplication.Blog.Payloads.PostDto;
import com.BlogApplication.Blog.Repo.PostRepo;
import com.BlogApplication.Blog.Repo.UserRepo;
import com.BlogApplication.Blog.Repo.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private UserRepo userRepo;
    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        userEntity UserEntity = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("userEntity", "User id", userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
        PostEntity postEntity = this.modelMapper.map(postDto, PostEntity.class);
        postEntity.setImageName("default.png");
        postEntity.setAddedDate(new Date());
        postEntity.setCategory(category);
        postEntity.setUser(UserEntity);
        PostEntity newPost = this.postRepo.save(postEntity);
        return this.modelMapper.map(newPost, PostDto.class);
    }
    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        PostEntity post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","postId",postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        PostEntity updatedPost=this.postRepo.save(post);
        return this.modelMapper.map(updatedPost,PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        PostEntity post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","postId",postId));
        this.postRepo.delete(post);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<PostEntity>posts=this.postRepo.findAll();
        List<PostDto>postDtos=posts.stream().map((post) ->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        PostEntity post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post id", postId));
        return this.modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));
       List<PostEntity>posts= this.postRepo.findByCategory(cat);
       List<PostDto>postDtos=posts.stream().map((post) ->this.modelMapper.map(posts,PostDto.class)).collect(Collectors.toList());
       return postDtos;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        userEntity user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User id",userId));
        List<PostEntity> posts=this.postRepo.findByUser(user);
        List<PostDto>postDto=posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDto;
    }
    @Override
    public List<PostDto> searchPosts(String keyword)
    {
        List<PostEntity>posts=this.postRepo.findByTitleContaining(keyword);
       List<PostDto>postDto= posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
       return postDto;
    }
}
