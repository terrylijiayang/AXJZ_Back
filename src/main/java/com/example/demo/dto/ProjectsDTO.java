package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: ProjectsDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/2/16 12:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/16 12:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ProjectsDTO {
    private  int projectId;
    private  int categoryId;
    private  int userId;
    private String projectName;
    private Double raisedFunds;
    private Double budget;
    private String projectImagePath;
    private int participantNumber;
    private String introduce;
    private String projectPlan;
    private String budgetBreakdown;
    private String categoryName;
    private  int state;
    private Date addTime;
    private Date startingTime;
    private Date endingTime;
    private String nickName;
    private String realName;
    //捐款数量
    private int donationNumber;
    private int donationAmount;

    public int getDonationNumber() {
        return donationNumber;
    }

    public void setDonationNumber(int donationNumber) {
        this.donationNumber = donationNumber;
    }

    public int getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(int donationAmount) {
        this.donationAmount = donationAmount;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getProjectPlan() {
        return projectPlan;
    }

    public void setProjectPlan(String projectPlan) {
        this.projectPlan = projectPlan;
    }

    public String getBudgetBreakdown() {
        return budgetBreakdown;
    }

    public void setBudgetBreakdown(String budgetBreakdown) {
        this.budgetBreakdown = budgetBreakdown;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Double getRaisedFunds() {
        return raisedFunds;
    }

    public void setRaisedFunds(Double raisedFunds) {
        this.raisedFunds = raisedFunds;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getProjectImagePath() {
        return projectImagePath;
    }

    public void setProjectImagePath(String projectImagePath) {
        this.projectImagePath = projectImagePath;
    }

    public int getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(int participantNumber) {
        this.participantNumber = participantNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
    }
}
