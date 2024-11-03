package com.BlogApplication.Blog.Service;

import com.BlogApplication.Blog.Payloads.CommentDto;

import java.util.List;

public interface CommentService {
//    create comment
    CommentDto createComment(CommentDto commentDto, Integer postId);
//    update comment
//    CommentDto updateComment(CommentDto commentDto, Integer commentId);
//    Delete comment
    void deleteComment(Integer commentId);
//    get comments
//     List<CommentDto> getAllComments();
//     get comment by id
//    CommentDto getCommentById(Integer commentId);
}
