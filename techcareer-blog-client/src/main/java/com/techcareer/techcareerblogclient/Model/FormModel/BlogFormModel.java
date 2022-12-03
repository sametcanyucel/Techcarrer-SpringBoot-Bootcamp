package com.techcareer.techcareerblogclient.Model.FormModel;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

public class BlogFormModel {
    @NotEmpty(message = "Boş Bıraklıamaz")
    private String blogWriter;
    private String blogDate;
    @NotEmpty(message = "Boş Bıraklıamaz")
    private String blogTittle;
    @NotEmpty(message = "Boş Bıraklıamaz")
    private String blogContent;
    private MultipartFile blogImages;
    private byte blogStatus;
    private String categoryName;
    private long categoryId;
    @NotEmpty(message = "Boş Bıraklıamaz")
    private String blogLongTittle;

    public String getBlogWriter() {
        return blogWriter;
    }

    public void setBlogWriter(String blogWriter) {
        this.blogWriter = blogWriter;
    }

    public String getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(String blogDate) {
        this.blogDate = blogDate;
    }

    public String getBlogTittle() {
        return blogTittle;
    }

    public void setBlogTittle(String blogTittle) {
        this.blogTittle = blogTittle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public MultipartFile getBlogImages() {
        return blogImages;
    }

    public void setBlogImages(MultipartFile blogImages) {
        this.blogImages = blogImages;
    }

    public byte getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(byte blogStatus) {
        this.blogStatus = blogStatus;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getBlogLongTittle() {
        return blogLongTittle;
    }

    public void setBlogLongTittle(String blogLongTittle) {
        this.blogLongTittle = blogLongTittle;
    }
}
