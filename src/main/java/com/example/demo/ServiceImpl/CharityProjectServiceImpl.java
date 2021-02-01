package com.example.demo.ServiceImpl;

import com.example.demo.Service.CharityProjectService;
import com.example.demo.dao.mapper.CategoryMapper;
import com.example.demo.dao.mapper.CharityProjectMapper;
import com.example.demo.dao.mapper.DonationRecordMapper;
import com.example.demo.dao.mapper.UserMapper;
import com.example.demo.dto.*;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Component
@Transactional
@Service
public class CharityProjectServiceImpl implements CharityProjectService{
    @Autowired
    private final CategoryMapper categoryMapper;
    @Autowired
    private final CharityProjectMapper charityProjectMapper;
    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final DonationRecordMapper donationRecordMapper;
    public CharityProjectServiceImpl(CategoryMapper categoryMapper,CharityProjectMapper charityProjectMapper,DonationRecordMapper donationRecordMapper,UserMapper userMapper){
        this.categoryMapper = categoryMapper;
        this.charityProjectMapper = charityProjectMapper;
        this.donationRecordMapper = donationRecordMapper;
        this.userMapper=userMapper;
    }
    @Override
    public List<Category> getAllCategory() {//获取所有项目类别
        return categoryMapper.getAllCategory();
    }

    @Override
    public List<UserProjectsDTO> getAllProjects(PageDTO pageDTO) {
        return charityProjectMapper.getAllProjects(pageDTO);
    }

    @Override
    public int AllProjectsNum() {
        return charityProjectMapper.AllProjectsNum();
    }

    @Override
    public Category getCategoryById(int categoryId) {

        return categoryMapper.getCategoryById(categoryId);
    }

    @Override
    public List<CharityProject> getCharityProjectByCategoryId(int categoryId) {

        return charityProjectMapper.getCharityProjectByCategoryId(categoryId);
    }

    @Override
    public List<CharityProject> getThreeCharityProjectByCategoryId(int categoryId) {
        List<CharityProject> allProjects = getCharityProjectByCategoryId(categoryId);
        List<CharityProject> projects = new ArrayList<>();
        for(int i = 0;i < allProjects.size();i++){
            projects.add(allProjects.get(i));
        }
        return projects;
    }

    @Override
    public List<List<CharityProject>> getHomepageCharityProject(List<Category> categorys) {
        List<List<CharityProject>> homepageProjects = new ArrayList<>();
        for(int i = 0;i < categorys.size();i++){
            int id = categorys.get(i).getCategoryId();
            List<CharityProject> projects = getThreeCharityProjectByCategoryId(id);
            homepageProjects.add(projects);
        }
        return homepageProjects;
    }

    @Override
    public ProjectsDTO getCharityProjectById(int charityProjectId) {
        return charityProjectMapper.getCharityProjectById(charityProjectId);
    }

    @Override
    public List<Feedback> getFeedbackByProjectId(int charityProjectId) {
        return charityProjectMapper.getFeedbackByProjectId(charityProjectId);
    }

    @Override
    public List<FundRecordDTO> getFundRecordByProjectId(int charityProjectId) {
        return charityProjectMapper.getFundRecordByProjectId(charityProjectId);
    }

    @Override
    public boolean addDonationRecord(DonationRecord donationRecord) {
        int userId = donationRecord.getUserId();
        int projectId = donationRecord.getProjectId();
        CharityProject charityProject= new CharityProject();
        charityProject.setProjectId(projectId);
        charityProject.setRaisedFunds(donationRecord.getDonationAmount());
        DonationRecord dr = getDonationRecordByUserIdAndProjectId(userId,projectId);
        //如果以前捐赠过
        if(dr != null){
            double newAmount = dr.getDonationAmount() + donationRecord.getDonationAmount();
            dr.setDonationNumber(dr.getDonationNumber() + 1);
            dr.setDonationAmount(newAmount);
            charityProject.setParticipantNumber(0);
            charityProjectMapper.updateCharityProject(charityProject);
            if(updateDonationRecord(dr))//是否更新成功
                return true;
            else
                return false;
        }
        //第一次新添加
        else{
            donationRecord.setDonationNumber(1);
            if(donationRecordMapper.addDonationRecord(donationRecord) >= 0){
                charityProject.setParticipantNumber(1);
                charityProjectMapper.updateCharityProject(charityProject);
                return true;
            }else{
                return false;
            }
        }
    }
    @Override
    public boolean updateDonationRecord(DonationRecord donationRecord) {
        if(donationRecordMapper.updateDonationRecord(donationRecord) > 0)
            return true;
        return false;
    }

    @Override
    public boolean checkProject(int projectId) {
        return charityProjectMapper.updateProjectState(projectId)>0?true:false;
    }

    @Override
    public DonationRecord getDonationRecordByUserIdAndProjectId(int userId, int projectId) {
        return donationRecordMapper.getDonationRecordByUserIdAndProjectId(userId,projectId);
    }

    @Override
    public boolean addCharityProject(CharityProject charityProject) {
        if(charityProjectMapper.addCharityProject(charityProject)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delProjectById(int charityProjectId) {
        return charityProjectMapper.delProjectById(charityProjectId)>0 ? true:false;
    }

    @Override
    public boolean addProMessage(Message message) {
        return charityProjectMapper.addProMessage(message)>0?true:false;
    }

    @Override
    public boolean delProMessageById(int messageId) {
        return charityProjectMapper.delProMessageById(messageId)>0?true:false;
    }

    @Override
    public boolean addProMessageReply(MessageReply messageReply) {
        return charityProjectMapper.addProMessageReply(messageReply)>0?true:false;
    }

    @Override
    public List<MessageDTO> getMessagesByProjectId(int charityProjectId){
        return charityProjectMapper.getMessagesByProjectId(charityProjectId);
    }

    @Override
    public List<MessageReplyDTO> getReplyByMessageId(int messageId) {
        return charityProjectMapper.getReplyByMessageId(messageId);
    }

    @Override
    public boolean delReplyByMessageId(int replyId) {
        return charityProjectMapper.delReplyByMessageId(replyId)>0?true:false;
    }

    @Override
    public List<UserProjectsDTO> userHelpProjects(UserHelpProjectsDTO userHelpProjectsDTO) {
        return charityProjectMapper.userHelpProjects(userHelpProjectsDTO);
    }

    @Override
    public int userHelpProjectsNum(int userId) {
        return charityProjectMapper.userHelpProjectsNum(userId);
    }

    @Override
    public boolean addFeedBack(AddFeedBackDTO addFeedBackDTO) {
        return charityProjectMapper.addFeedback(addFeedBackDTO)>0 ? true:false;
    }

    @Override
    public boolean useFund(FundRecord fundRecord) {
        charityProjectMapper.updateProjectFund(fundRecord);
        return charityProjectMapper.useFund(fundRecord)>0?true:false;
    }

    @Override
    public double getAllRaisedFunds() {
        return charityProjectMapper.getAllRaisedFunds();
    }

    @Override
    public double getSurplusFunds() {
        return charityProjectMapper.getSurplusFunds();
    }

    @Override
    public double getUsedFunds() {
        return charityProjectMapper.getUsedFunds();
    }

    @Override
    public double getBudgetFunds() {
        return charityProjectMapper.getBudgetFunds();
    }

    @Override
    public int getDonationUserNum() {
        return donationRecordMapper.getDonationUserNum();
    }

    @Override
    public double getDonationAverage() {
        return donationRecordMapper.getDonationAverage();
    }

    @Override
    public int getHelpUsers() {
        return charityProjectMapper.getHelpUsers();
    }

    @Override
    public List<HomeRankListDTO> getTopUser() {
        return donationRecordMapper.getTopUser();
    }

    @Override
    public int getAllUsersNum() {
        return userMapper.AllUsersNum();
    }

    @Override
    public List<Integer> getSixMonthNums() {
        return charityProjectMapper.getSixMonthNums();
    }

    @Override
    public List<Double> getSixMonthRaised() {
        return charityProjectMapper.getSixMonthRaised();
    }

    @Override
    public List<Double> getSixMonthUsed() {
        return charityProjectMapper.getSixMonthUsed();
    }

    @Override
    public double getDonationNums(int start, int end) {
        return donationRecordMapper.getDonationNums(start,end);
    }

    @Override
    public double getDonationRatio(int start, int end) {
        return donationRecordMapper.getDonationRatio(start,end);
    }

    @Override
    public boolean addProTask(TaskDTO taskDTO) {
        charityProjectMapper.PrStateWait(taskDTO.getProjectId());
        return charityProjectMapper.addProTask(taskDTO)>0?true:false;
    }

    @Override
    public List<CharityProject> getTaskByUserId(TaskPageDTO taskPageDTO) {
        return charityProjectMapper.getTaskByUserId(taskPageDTO);
    }

    @Override
    public int getTaskNumByUserId(int userId) {
        return charityProjectMapper.getTaskNumByUserId(userId);
    }

    @Override
    public boolean updateProTask(UpdateTaskDTO updateTaskDTO) {
        if(updateTaskDTO.getState()==-1){//审核不通过
            charityProjectMapper.stopProState(updateTaskDTO.getProjectId());
        }
        //修改审核状态
        charityProjectMapper.updateProTask(updateTaskDTO);
        charityProjectMapper.waitProState(updateTaskDTO.getProjectId());
        //都审核通过就把项目的状态修改
        return  charityProjectMapper.updateProState(updateTaskDTO.getProjectId())>0?true:false;
    }

    @Override
    public List<TaskProcessDTO> getTaskProcess(int projectId) {
        return charityProjectMapper.getTaskProcess(projectId);
    }

    @Override
    public List<CharityProject> recommendProjectsByCategoryId(int categoryId) {
        return charityProjectMapper.recommendProjectsByCategoryId(categoryId);
    }

    @Override
    public List<DonationRecord> getDonationRecordByUserId(int userId) {
        List<DonationRecord> donationRecords = donationRecordMapper.getDonationRecordByUserId(userId);
        return donationRecords;
    }


}
