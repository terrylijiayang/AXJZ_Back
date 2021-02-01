package com.example.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class MessageReply {
    private int id;

    private String content;

    private int replymanId;

    private int projectId;

    private int messageId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @ApiModelProperty(value = "留言回复id", name = "id", dataType = "Integer")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ApiModelProperty(value = "回复内容", name = "content", dataType = "String")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ApiModelProperty(value = "回复用户id", name = "replymanId", dataType = "Integer")
    public int getReplymanId() {
        return replymanId;
    }

    public void setReplymanId(int replymanId) {
        this.replymanId = replymanId;
    }

    @ApiModelProperty(value = "项目id", name = "projectId", dataType = "Integer")
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @ApiModelProperty(value = "留言id", name = "messageId", dataType = "Integer")
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @ApiModelProperty(value = "回复时间", name = "createdAt", dataType = "Integer")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
