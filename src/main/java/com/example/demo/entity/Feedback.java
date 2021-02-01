package com.example.demo.entity;
import java.sql.Date;
public class Feedback {
    private int feedbackId;
    private int projectId;
    private Date createdAt;
    private String feedbackName;
    private String content;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setFeedbackName(String feedbackName) {
        this.feedbackName = feedbackName;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public int getProjectId() {
        return projectId;
    }


    public String getFeedbackName() {
        return feedbackName;
    }

}
