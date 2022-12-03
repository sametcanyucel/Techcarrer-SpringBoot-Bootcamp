package com.techcareer.techcareerblogclient.Model;

public class CategoryModel {
    private long categoryId;
    private String categoryName;
    private byte categoryStatus;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public byte getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(byte categoryStatus) {
        this.categoryStatus = categoryStatus;
    }
}
