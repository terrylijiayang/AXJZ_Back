package com.example.demo.entity;

public class Category {
    private int categoryId;
    private String categoryName;
    private String categoryIntroduce;

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryIntroduce() {
        return categoryIntroduce;
    }

    public void setCategoryIntroduce(String categoryIntroduce) {
        this.categoryIntroduce = categoryIntroduce;
    }
}
