package com.BlogApplication.Blog.Payloads;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private int id;
    private String content;
}
