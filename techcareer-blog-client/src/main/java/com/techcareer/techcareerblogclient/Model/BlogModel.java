package com.techcareer.techcareerblogclient.Model;

import java.util.Date;

public class BlogModel {

    private String blogWriter;
    private String blogDate;
    private String blogTittle;
    private String blogContent;
    private String blogImages;
    private byte blogStatus;
    private String blogLongTittle;

    private String categoryName;
    private long categoryId;

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

    public String getBlogImages() {
        return blogImages;
    }

    public void setBlogImages(String blogImages) {
        this.blogImages = blogImages;
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

    public byte getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(byte blogStatus) {
        this.blogStatus = blogStatus;
    }

    public String getBlogLongTittle() {
        return blogLongTittle;
    }

    public void setBlogLongTittle(String blogLongTittle) {
        this.blogLongTittle = blogLongTittle;
    }
}
