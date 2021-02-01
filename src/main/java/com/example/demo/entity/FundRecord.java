package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.entity
 * @ClassName: FundRecord
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/3/11 21:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/11 21:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FundRecord {
    private int fundId;
    private int userId;
    private int projectId;
    private double fund;
    private String content;
    private Date createdAt;

    public int getFundId() {
        return fundId;
    }

    public void setFundId(int fundId) {
        this.fundId = fundId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
