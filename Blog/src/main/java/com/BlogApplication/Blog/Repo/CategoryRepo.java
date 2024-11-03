package com.BlogApplication.Blog.Repo;

import com.BlogApplication.Blog.Entity.Category;
//import com.BlogApplication.Blog.Payloads.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
