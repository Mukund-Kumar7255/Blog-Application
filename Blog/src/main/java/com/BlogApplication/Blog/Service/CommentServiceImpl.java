package com.BlogApplication.Blog.Service;

import com.BlogApplication.Blog.Entity.CommentEntity;
import com.BlogApplication.Blog.Entity.PostEntity;
import com.BlogApplication.Blog.Exception.ResourceNotFoundException;
import com.BlogApplication.Blog.Payloads.CommentDto;
import com.BlogApplication.Blog.Repo.CommentRepo;
import com.BlogApplication.Blog.Repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        PostEntity post=this.postRepo.findById(postId).orElseThrow(() ->new ResourceNotFoundException("Post","post id",postId));
        CommentEntity comment=this.modelMapper.map(commentDto, CommentEntity.class);
        comment.setPost(post);
        return this.modelMapper.map(this.commentRepo.save(comment),CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        CommentEntity comment=this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment","comment id",commentId));
        this.commentRepo.delete(comment);
    }
}
