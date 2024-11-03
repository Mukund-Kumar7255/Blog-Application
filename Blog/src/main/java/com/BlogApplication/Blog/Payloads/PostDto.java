package com.BlogApplication.Blog.Payloads;

import com.BlogApplication.Blog.Entity.Category;
import com.BlogApplication.Blog.Entity.userEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private String title;
    private String content;
   private String imageName;
   private Date addedDate;

    private CategoryDto category;

    private UserDto user;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private Set<CommentDto> comment=new HashSet<>();
}
