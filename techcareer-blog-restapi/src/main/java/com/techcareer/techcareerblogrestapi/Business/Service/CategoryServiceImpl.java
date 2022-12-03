package com.techcareer.techcareerblogrestapi.Business.Service;

import com.techcareer.techcareerblogrestapi.Business.Dto.CategoryDto;
import com.techcareer.techcareerblogrestapi.Entity.Category;
import com.techcareer.techcareerblogrestapi.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryDto getCategory(long categoryId) {

        return toDto(categoryRepository.findById(categoryId));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> entityList = categoryRepository.findAll();
        List<CategoryDto> dtoList = new ArrayList<>();
        for (Category category : entityList) {

                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setCategoryId(category.getCategoryId());
                categoryDto.setCategoryName(category.getCategoryName());
                categoryDto.setCategoryStatus(category.getCategoryStatus());

                dtoList.add(categoryDto);


        }
        return dtoList;
    }

    @Override
    public List<CategoryDto> getCategoriesByStatus() {
        List<Category> entityList = categoryRepository.findAll();
        List<CategoryDto> dtoList = new ArrayList<>();
        for (Category category : entityList) {
            if (category.getCategoryStatus() == 1) {
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setCategoryId(category.getCategoryId());
                categoryDto.setCategoryName(category.getCategoryName());
                categoryDto.setCategoryStatus(category.getCategoryStatus());

                dtoList.add(categoryDto);
            }

        }
        return dtoList;
    }

    @Override
    public void addCategory(CategoryDto categoryDto) {

        categoryRepository.save(toEntity(categoryDto));
    }
    @Override
    public void updateCategory(CategoryDto categoryDto,long categoryId) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        category.setCategoryName(categoryDto.getCategoryName());
        category.setCategoryStatus(categoryDto.getCategoryStatus());
        category.setBlogList(category.getBlogList());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public void setCategoryStatus(long categoryId) {
        Optional<Category> optional = categoryRepository.findById(categoryId);
        if (optional.isPresent()) {
            Category cart = optional.get();
            cart.setCategoryStatus((byte) 1);
            categoryRepository.save(cart);
        }
    }

    @Override
    public void setCategoryStatusFalse(long categoryId) {
        Optional<Category> optional = categoryRepository.findById(categoryId);
        if (optional.isPresent()) {
            Category cart = optional.get();
            cart.setCategoryStatus((byte) 0);
            categoryRepository.save(cart);
        }
    }

    public Category toEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setCategoryStatus(categoryDto.getCategoryStatus());
        category.setBlogList(category.getBlogList());

        return category;
    }

    public CategoryDto toDto(Optional<Category> optional) {
        CategoryDto categoryDto = new CategoryDto();
        if (optional.isPresent()) {
            Category category = optional.get();
            categoryDto.setCategoryId(category.getCategoryId());
            categoryDto.setCategoryName(category.getCategoryName());
            categoryDto.setCategoryStatus(category.getCategoryStatus());

        }
        return categoryDto;
    }
}
