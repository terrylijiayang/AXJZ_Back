package com.example.demo.dao.mapper;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharityProjectMapper {
    public List<CharityProject> getCharityProjectByCategoryId(int categoryId);
    //项目
    public List<UserProjectsDTO> getAllProjects(PageDTO pageDTO);
    //项目总量
    public int AllProjectsNum();
    public ProjectsDTO getCharityProjectById(int charityProjectId);
    public List<Feedback> getFeedbackByProjectId(int charityProjectId);
    public List<FundRecordDTO> getFundRecordByProjectId(int charityProjectId);
    public int addCharityProject(CharityProject charityProject);
    public int updateCharityProject(CharityProject charityProject);
    public int PrStateWait(int charityProjectId);
    public int updateProjectState(int charityProject);
    public int delProjectById(int charityProjectId);
    public int addProMessage(Message message);
    public int delProMessageById(int messageId);
    public int addProMessageReply(MessageReply messageReply);
    public List<MessageDTO> getMessagesByProjectId(int charityProjectId);
    //留言回复
    public List<MessageReplyDTO> getReplyByMessageId(int messageId);
    public int delReplyByMessageId(int replyId);
    //查看用户申请的项目
    public List<UserProjectsDTO> userHelpProjects(UserHelpProjectsDTO userHelpProjectsDTO);
    public int userHelpProjectsNum(int userId);
    //新增反馈
    public int addFeedback(AddFeedBackDTO addFeedBackDTO);
    //提取资金并更新项目当前使用资金
    public int useFund(FundRecord fundRecord);
    public int updateProjectFund(FundRecord fundRecord);
    //获取后台首页信息
    public double getAllRaisedFunds();
    public double getSurplusFunds();
    public double getUsedFunds();
    public double getBudgetFunds();
    public int  getHelpUsers();
    //最近六个月
    public List<Integer> getSixMonthNums();
    public List<Double> getSixMonthRaised();
    public List<Double> getSixMonthUsed();
    //下发审核
    public int addProTask(TaskDTO taskDTO);
    public List<CharityProject> getTaskByUserId(TaskPageDTO taskPageDTO);
    public int getTaskNumByUserId(int userId);
    public int updateProTask(UpdateTaskDTO updateTaskDTO);
    public int updateProState(int projectId);
    public int stopProState(int projectId);
    public int waitProState(int projectId);
    public List<TaskProcessDTO> getTaskProcess(int projectId);

    public  List<CharityProject> recommendProjectsByCategoryId(int categoryId);
}
