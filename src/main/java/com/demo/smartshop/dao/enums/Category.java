package com.demo.smartshop.dao.enums;

public enum Category {
    EXOTIC(1, "Exotic", "From other countries"),
    NATIVE(2, "Native", "British flowers");

    final int categoryId;
    final String categoryName;
    final String categoryDetails;

    Category(int categoryId, String categoryName, String categoryDetails) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDetails = categoryDetails;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDetails() {
        return categoryDetails;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryId=" + categoryId
                + ", categoryName=" + categoryName
                + ", categoryDetails=" + categoryDetails + '}';
    }
}