package com.techcareer.techcareerblogrestapi.Controller;

import com.techcareer.techcareerblogrestapi.Business.Dto.CategoryDto;
import com.techcareer.techcareerblogrestapi.Business.Service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("/category/{id}")
    public CategoryDto getCategory(@PathVariable("id") long categoryId) {
        return categoryService.getCategory(categoryId);
    }
    @GetMapping("/category/")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }
    @GetMapping("/categorybystatus/")
    public List<CategoryDto> getCategoriesByStatus() {
        return categoryService.getCategoriesByStatus();
    }

    @PostMapping("/category/add")
    public String addCategory(@RequestBody  CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);

        return "Kategori Eklendi " + categoryDto.getCategoryId();
    }
    @PostMapping("/categoryupdate/{id}")
    public String updateCategory(@RequestBody  CategoryDto categoryDto,@PathVariable("id") long categoryId) {
        categoryService.addCategory(categoryDto);

        return "Kategori Güncellendi " + categoryDto.getCategoryId();
    }

    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable("id") long categoryId) {
        categoryService.deleteCategory(categoryId);
        return "Kategori Silindi ID: " + categoryId;
    }
    @PutMapping("/category/{id}")
    public String setCategoryStatus(@PathVariable("id")long categoryId){

        categoryService.setCategoryStatus(categoryId);
        return "Kategori Statüsü Değişti ID : "+categoryId;
    }
    @PutMapping("/categorysetfalse/{id}")
    public String setCategoryStatusFalse(@PathVariable("id")long categoryId){

        categoryService.setCategoryStatusFalse(categoryId);
        return "Kategori Statüsü Pasif Olarak Değişti ID : "+categoryId;
    }

}
