package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: AddFeedBackDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/2/21 11:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/21 11:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AddFeedBackDTO {
    private int feedbackId;
    private int projectId;
    private int userId;
    private Date createdAt;
    private String content;

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
}
