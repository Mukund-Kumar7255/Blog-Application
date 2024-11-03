package com.BlogApplication.Blog.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "Comment")
@Getter
@Setter
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;

    @ManyToOne
    private PostEntity post;
}
