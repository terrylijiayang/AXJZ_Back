package com.example.demo.dto;

import java.util.Date;
import java.util.List;

public class TaskDTO {
    private int projectId;
    private List<Integer> userValue;
    private Date createdAt;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public List<Integer> getUserValue() {
        return userValue;
    }

    public void setUserValue(List<Integer> userValue) {
        this.userValue = userValue;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
