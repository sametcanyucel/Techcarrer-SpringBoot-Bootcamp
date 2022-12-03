package com.techcareer.techcareerblogrestapi.Business.Service;

import com.techcareer.techcareerblogrestapi.Business.Dto.BlogDto;
import com.techcareer.techcareerblogrestapi.Business.Dto.CategoryDto;
import com.techcareer.techcareerblogrestapi.Entity.Blog;
import com.techcareer.techcareerblogrestapi.Entity.Category;
import com.techcareer.techcareerblogrestapi.Repository.BlogRepository;
import com.techcareer.techcareerblogrestapi.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void addBlog(BlogDto blogDto) {

        blogRepository.save(toEntityBlog(blogDto));
    }

    @Override
    public void deleteBlog(long blogId) {
        Optional<Blog>optional=blogRepository.findById(blogId);
        if(optional.isPresent()){
            Blog blog=optional.get();
            blogRepository.delete(blog);

        }
    }

    @Override
    public BlogDto getBlog(long blogId) {
        return toDtoBlog(blogRepository.findById(blogId));
    }

    @Override
    public List<BlogDto> getAllBlogs() {
        List<Blog>blogList=blogRepository.findAll();
        List<BlogDto>blogDtoList=new ArrayList<>();
        for (Blog blog:blogList) {
            BlogDto blogDto=toDtoBlog(Optional.ofNullable(blog));
            blogDtoList.add(blogDto);
        }
        return blogDtoList;
    }
    @Override
    public List<BlogDto> getActiveBlogs() {
        List<Blog>blogList=blogRepository.findAll();
        List<BlogDto>blogDtoList=new ArrayList<>();
        for (Blog blog:blogList) {
            if (blog.getBlogStatus()==1){
                BlogDto blogDto=toDtoBlog(Optional.ofNullable(blog));
                blogDtoList.add(blogDto);
            }

        }
        return blogDtoList;
    }


    @Override
    public List<BlogDto> getBlogsByCategoryId(long categoryId) {
        List<Blog>blogList=blogRepository.getBlogsByCategoryId(categoryId);
        List<BlogDto>blogDtoList=new ArrayList<>();
        for (Blog blog:blogList) {
            BlogDto blogDto=new BlogDto();
            blogDto=toDtoBlog(Optional.ofNullable(blog));
            blogDtoList.add(blogDto);
        }
       return blogDtoList;
    }

    @Override
    public void setBlogActive(long blogId) {
        Optional<Blog> optional = blogRepository.findById(blogId);
        if (optional.isPresent()) {
            Blog cart = optional.get();
            cart.setBlogStatus((byte) 1);
            blogRepository.save(cart);
        }
    }

    @Override
    public void setBlogPasive(long blogId) {
        Optional<Blog> optional = blogRepository.findById(blogId);
        if (optional.isPresent()) {
            Blog cart = optional.get();
            cart.setBlogStatus((byte) 0);
            blogRepository.save(cart);
        }
    }

    @Override
    public void updateBlog( BlogDto blogDto) {
  blogRepository.save(toEntityBlog(blogDto));
    }

    public Blog toEntityBlog(BlogDto blogDto) {
        Blog blog = new Blog();

        blog.setBlogTittle(blogDto.getBlogTittle());
        blog.setBlogDate(blogDto.getBlogDate());
        blog.setBlogId(blogDto.getBlogId());
        blog.setBlogImages(blogDto.getBlogImages());
        blog.setBlogContent(blogDto.getBlogContent());
        blog.setBlogLongTittle(blogDto.getBlogLongTittle());
        blog.setBlogWriter(blogDto.getBlogWriter());
        blog.setBlogStatus(blogDto.getBlogStatus());
        blog.setCategory(findblogById(blogDto.getCategoryId()));
        return blog;
    }

    public BlogDto toDtoBlog(Optional<Blog> optional) {
        BlogDto blogDto = new BlogDto();
        if (optional.isPresent()) {

            Blog blog = optional.get();
            blogDto.setBlogTittle(blog.getBlogTittle());
            blogDto.setBlogDate(blog.getBlogDate());
            blogDto.setBlogId(blog.getBlogId());
            blogDto.setBlogImages(blog.getBlogImages());
            blogDto.setBlogContent(blog.getBlogContent());
            blogDto.setBlogWriter(blog.getBlogWriter());
            blogDto.setBlogStatus(blog.getBlogStatus());
            blogDto.setBlogLongTittle(blog.getBlogLongTittle());
            blogDto.setCategoryId(blog.getCategory().getCategoryId());
            blogDto.setCategoryName(blog.getCategory().getCategoryName());

        }
        return blogDto;
    }

    public Category findblogById(long blogId) {
        Optional<Category> optional = categoryRepository.findById(blogId);
        if (optional.isPresent()) {
            Category category = optional.get();
            return category;
        }

        return null;
    }


}
