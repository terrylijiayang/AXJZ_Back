package com.example.demo.dto;

import com.example.demo.entity.CharityProject;

import java.util.List;

public class TaskByUserIdDTO {
    private  int total;
    private List<CharityProject> charityProjects;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<CharityProject> getCharityProjects() {
        return charityProjects;
    }

    public void setCharityProjects(List<CharityProject> charityProjects) {
        this.charityProjects = charityProjects;
    }
}
