package com.techcareer.techcareerblogrestapi.Business.Service;

import com.techcareer.techcareerblogrestapi.Business.Dto.BlogDto;
import com.techcareer.techcareerblogrestapi.Business.Dto.CategoryDto;

import java.util.List;

public interface BlogService {
    public void addBlog(BlogDto blogDto);
    public void deleteBlog(long blogID);
    public BlogDto getBlog(long blogID);
    public List<BlogDto> getAllBlogs();
    public List<BlogDto> getActiveBlogs();
    public List<BlogDto> getBlogsByCategoryId(long categoryId);
    public void setBlogActive(long blogId);
    public void setBlogPasive(long blogId);


    public void updateBlog(BlogDto blogDto);

}
