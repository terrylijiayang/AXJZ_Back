package com.example.demo.Service;

import com.example.demo.dto.*;
import com.example.demo.entity.*;

import java.util.List;

public interface CharityProjectService {
    public List<Category> getAllCategory();
    //展示项目以及数量
    public List<UserProjectsDTO> getAllProjects(PageDTO pageDTO);
    public int AllProjectsNum();
    public Category getCategoryById(int categoryId);
    public List<CharityProject> getCharityProjectByCategoryId(int categoryId);
    public List<CharityProject> getThreeCharityProjectByCategoryId(int categoryId);
    public List<List<CharityProject>> getHomepageCharityProject(List<Category> categorys);
    public ProjectsDTO getCharityProjectById(int charityProjectId);
    public List<Feedback> getFeedbackByProjectId(int charityProjectId);
    public List<FundRecordDTO> getFundRecordByProjectId(int charityProjectId);
    public boolean addDonationRecord(DonationRecord donationRecord);
    public boolean updateDonationRecord(DonationRecord donationRecord);
    //审核通过
    public boolean checkProject(int projectId);
    public List<DonationRecord> getDonationRecordByUserId(int userId);
    public DonationRecord getDonationRecordByUserIdAndProjectId(int userId,int projectId);
    public boolean addCharityProject(CharityProject charityProject);
    public boolean delProjectById(int charityProjectId);
    public boolean addProMessage(Message message);
    public boolean delProMessageById(int messageId);
    public boolean addProMessageReply(MessageReply messageReply);
    public List<MessageDTO> getMessagesByProjectId(int charityProjectId);
    //留言回复
    public List<MessageReplyDTO> getReplyByMessageId(int messageId);
    public boolean delReplyByMessageId(int replyId);
    //用户申请项目
    public List<UserProjectsDTO> userHelpProjects(UserHelpProjectsDTO userHelpProjectsDTO);
    public int userHelpProjectsNum(int userId);
    //新增反馈
    public boolean addFeedBack(AddFeedBackDTO addFeedBackDTO);
    //使用资金
    public boolean useFund(FundRecord fundRecord);
    //后台首页
    public double getAllRaisedFunds();
    public double getSurplusFunds();
    public double getUsedFunds();
    public double getBudgetFunds();
    public int getDonationUserNum();
    public double getDonationAverage();
    public int  getHelpUsers();
    //慈善排行榜
    public List<HomeRankListDTO> getTopUser();
    //获取用户
    public int getAllUsersNum();
    //最近六个月
    public List<Integer> getSixMonthNums();
    public List<Double> getSixMonthRaised();
    public List<Double> getSixMonthUsed();
    //捐款参与
    public double getDonationNums(int start,int end);
    public double getDonationRatio(int start,int end);
    //下发审核任务
    public boolean addProTask(TaskDTO taskDTO);
    public List<CharityProject> getTaskByUserId(TaskPageDTO taskPageDTO);
    public int getTaskNumByUserId(int userId);
    public boolean updateProTask(UpdateTaskDTO updateTaskDTO);
    public List<TaskProcessDTO> getTaskProcess(int projectId);
    public  List<CharityProject> recommendProjectsByCategoryId(int categoryId);
}
