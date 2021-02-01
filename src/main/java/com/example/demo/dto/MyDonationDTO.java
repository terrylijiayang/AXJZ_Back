package com.example.demo.dto;

import com.example.demo.entity.Category;
import com.example.demo.entity.CharityProject;
import com.example.demo.entity.DonationRecord;

import java.util.List;

public class MyDonationDTO {
    private int userId;
    private int page;
    private int pageSize;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
