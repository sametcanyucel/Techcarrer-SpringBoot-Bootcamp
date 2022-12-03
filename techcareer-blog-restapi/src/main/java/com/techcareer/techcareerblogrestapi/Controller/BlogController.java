package com.techcareer.techcareerblogrestapi.Controller;

import com.techcareer.techcareerblogrestapi.Business.Dto.BlogDto;
import com.techcareer.techcareerblogrestapi.Business.Service.BlogServiceImpl;
import com.techcareer.techcareerblogrestapi.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {
    @Autowired
    BlogServiceImpl blogService;



    @PostMapping("/blog/add")
    public String addBlog(@RequestBody BlogDto blogDto) {
        blogService.addBlog(blogDto);

        return "Blog Eklendi "+blogDto.getBlogId();
    }

    @GetMapping("/blog/{id}")
    public BlogDto getBlogById(@PathVariable("id") long blogId) {

        return blogService.getBlog(blogId);

    }
    @GetMapping("/blogs/{id}")
    public List<BlogDto> getBlogsByCategoryId(@PathVariable("id") long blogId) {

        return blogService.getBlogsByCategoryId(blogId);

    }
    @GetMapping("/blogs")
    public List<BlogDto> getAllBlogs() {

        return blogService.getAllBlogs();

    }
    @GetMapping("/blogs/active")
    public List<BlogDto> getActiveBlogs() {

        return blogService.getActiveBlogs();

    }

    @PutMapping("/blog")
    public String updateBlog(@RequestBody BlogDto blogDto) {
        blogService.updateBlog(blogDto);
        return blogDto.getBlogId() + " Id'li Blog güncellendi ";

    }
    @PutMapping("/blogstatusactive/{id}")
    public String setBlogActive(@PathVariable("id")long blogId) {
        blogService.setBlogActive(blogId);
        return blogId+" Id'li Blog güncellendi ";

    }
    @PutMapping("/blogstatuspassive/{id}")
    public String setBlogPassive(@PathVariable("id")long blogId) {
        blogService.setBlogPasive(blogId);
        return blogId+" Id'li Blog güncellendi ";

    }

    @DeleteMapping("/blog/{id}")
    public String deleteBlog(@PathVariable("id") long blogId) {
        blogService.deleteBlog(blogId);

        return blogId + " Id'li Blog silindi ";
    }
}
