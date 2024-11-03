package com.BlogApplication.Blog.Payloads;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    @Column(name = "categoryId")
    private Integer categoryId;
    private String categoryTitle;
    private String categoryDescription;
}
