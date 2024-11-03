package com.BlogApplication.Blog.Controller;

import com.BlogApplication.Blog.Payloads.CommentDto;
import com.BlogApplication.Blog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
//    create a new comment
    @PostMapping("/post/{postId}/comment")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId)
    {
        CommentDto commentDto=this.commentService.createComment(comment, postId);
        return new ResponseEntity<CommentDto>(commentDto, HttpStatus.CREATED);
    }
    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable Integer commentId)
    {
        this.commentService.deleteComment(commentId);
    }
}
