package com.BlogApplication.Blog.Controller;

import com.BlogApplication.Blog.Payloads.CategoryDto;
import com.BlogApplication.Blog.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;
    @PostMapping("/category")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto)
    {
        CategoryDto createCategory=this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer catId)
    {
        CategoryDto updateCategory=this.categoryService.updateCategory(categoryDto, catId);
        return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);
    }
    @DeleteMapping("/{catId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer catId)
    {
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer catId)
    {
        CategoryDto categoryDto=this.categoryService.getCategoryById(catId);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> getAllCategories()
    {
        List<CategoryDto>categories=this.categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
}
