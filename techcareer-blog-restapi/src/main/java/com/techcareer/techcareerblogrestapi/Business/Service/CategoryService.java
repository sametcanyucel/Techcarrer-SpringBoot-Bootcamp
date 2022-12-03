package com.techcareer.techcareerblogrestapi.Business.Service;

import com.techcareer.techcareerblogrestapi.Business.Dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    public CategoryDto getCategory(long categoryId);
    public List<CategoryDto> getAllCategories();
    public List<CategoryDto> getCategoriesByStatus();
    public void addCategory(CategoryDto categoryDto);
    public void deleteCategory(long categoryId);
    public void setCategoryStatus(long categoryId);
    public void setCategoryStatusFalse(long categoryId);
    public void updateCategory(CategoryDto categoryDto,long categoryId);

}
