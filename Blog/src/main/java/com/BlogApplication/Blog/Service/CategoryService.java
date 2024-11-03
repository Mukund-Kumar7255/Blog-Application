package com.BlogApplication.Blog.Service;

import com.BlogApplication.Blog.Payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    //create
     CategoryDto createCategory(CategoryDto categoryDto);
    //update
     CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
    //delete
     void deleteCategory(Integer categoryId);
    //get
     CategoryDto getCategoryById(Integer categoryId);
    //get all
    List<CategoryDto> getAllCategories();
}
