package com.example.demo.controller;

import com.example.demo.Service.CharityProjectService;
import com.example.demo.Service.UploadService;
import com.example.demo.Service.UserService;
import com.example.demo.dto.*;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

@RestController
@CrossOrigin
@RequestMapping(value = "/charityProject")
public class CharityProjectController {
    @Autowired
    private CharityProjectService charityProjectService;
    @Autowired
    public UploadService uploadService;

    public final static String[] REPLACE_STRING = new String[]{"GMT+0800", "GMT+08:00"};
    public final static String SPLIT_STRING = "(中国标准时间)";
    //展示主页
    @RequestMapping(value = "/homepage",method = RequestMethod.GET)
    public HomepageDTO showHomepage(){
        List<Category> categories = charityProjectService.getAllCategory();
        List<List<CharityProject>> homepageProjects = charityProjectService.getHomepageCharityProject(categories);
        List<Image> images = new ArrayList<>();
        HomepageDTO homepageDTO = new HomepageDTO(homepageProjects,categories,images);
        if(categories == null || homepageProjects == null)
            return null;
        return homepageDTO;
    }

    //展示项目
    @RequestMapping(value = "/projects",method = RequestMethod.POST)
    public ProjectsAllDTO showProjects(@Validated @RequestBody PageDTO pageDTO){
        //设置页数
        pageDTO.setPage(pageDTO.getPage()*pageDTO.getPageSize());
        //返回dto
        ProjectsAllDTO projectsAllDTO = new ProjectsAllDTO();
        projectsAllDTO.setProjectsDTOList(charityProjectService.getAllProjects(pageDTO));
        projectsAllDTO.setTotal(charityProjectService.AllProjectsNum());
        return projectsAllDTO;
    }

    //展示项目详情
    @RequestMapping(value = "/projectDetail",method = RequestMethod.GET)
    public ProjectDetailDTO showProjectDetail(@RequestParam int projectId){
        ProjectDetailDTO projectDetailDTO = new ProjectDetailDTO();
        List<Feedback> feedbackList = charityProjectService.getFeedbackByProjectId(projectId);
        List<FundRecordDTO> fundRecordDTOS=charityProjectService.getFundRecordByProjectId(projectId);
        ProjectsDTO charityProject = charityProjectService.getCharityProjectById(projectId);
        projectDetailDTO.setCharityProject(charityProject);
        projectDetailDTO.setFeedbacks(feedbackList);
        projectDetailDTO.setFundRecordDTOS(fundRecordDTOS);
        return projectDetailDTO;
    }

    //删除项目
    @RequestMapping(value = "/projectDelete",method = RequestMethod.GET)
    public int delProject(@RequestParam int projectId){
         return charityProjectService.delProjectById(projectId)==true ? 1 :0;
    }

    //用户求助项目
    @RequestMapping(value = "/userHelpProjects",method = RequestMethod.POST)
    public ProjectsAllDTO userHelpProjects(@Validated @RequestBody UserHelpProjectsDTO userHelpProjectsDTO){
        userHelpProjectsDTO.setPage(userHelpProjectsDTO.getPageSize()*userHelpProjectsDTO.getPage());
        ProjectsAllDTO projectsAllDTO = new ProjectsAllDTO();
        projectsAllDTO.setProjectsDTOList(charityProjectService.userHelpProjects(userHelpProjectsDTO));
        projectsAllDTO.setTotal(charityProjectService.userHelpProjectsNum(userHelpProjectsDTO.getUserId()));
        return  projectsAllDTO;
    }
    //新增反馈信息
    @RequestMapping(value = "/addFeedBack",method = RequestMethod.POST)
    public boolean addFeedBack(@Validated @RequestBody AddFeedBackDTO addFeedBackDTO){
        return charityProjectService.addFeedBack(addFeedBackDTO);
    }

    //使用资金
    @RequestMapping(value = "/useFund",method = RequestMethod.POST)
    public boolean useFund(@Validated @RequestBody FundRecord fundRecord){
        return charityProjectService.useFund(fundRecord);
    }
    //展示捐赠页面
    @RequestMapping(value = "/requestDonate",method = RequestMethod.GET)
    public ProjectsDTO showDonate(@RequestParam int projectId){
        ProjectsDTO charityProject = charityProjectService.getCharityProjectById(projectId);
        return  charityProject;
    }

    //接收捐赠信息
    @RequestMapping(value = "/submitDonate",method = RequestMethod.GET)
    public boolean submitDonate(@RequestParam int userId,int projectId,double donationAmount,String donorName){
        DonationRecord donationRecord = new DonationRecord(userId,projectId,donationAmount,donorName);
        if(charityProjectService.addDonationRecord(donationRecord))
            return true;
        return false;
    }

    //确定核实
    @RequestMapping(value = "/checkProject",method = RequestMethod.GET)
    public boolean checkProject(@RequestParam int projectId){
        return charityProjectService.checkProject(projectId);
    }

    //新增项目
    @RequestMapping(value = "/submitApplication",method = RequestMethod.POST)
    public boolean submitApplication(ApplicationProjectDTO applicationProjectDTO,  List<MultipartFile> files)throws Exception{

        CharityProject charityProject = new CharityProject();
        for(int i = 0;i < files.size();i++) {
            if (uploadService.upload(files.get(i)) == false) {
                return false;
            }
            String avatarPath = files.get(i).getOriginalFilename();
            charityProject.setProjectImagePath(avatarPath);
        }
        charityProject.setCategoryId(applicationProjectDTO.getCategoryId());
        charityProject.setProjectName(applicationProjectDTO.getProjectName());
        charityProject.setUserId(applicationProjectDTO.getUserId());
        charityProject.setRaisedFunds(0.0);
        charityProject.setUsedFunds(0.0);
        charityProject.setParticipantNumber(0);
        charityProject.setIntroduce(applicationProjectDTO.getIntroduce());
        charityProject.setProjectPlan(applicationProjectDTO.getProjectPlan());
        charityProject.setBudget(applicationProjectDTO.getBudget());
        charityProject.setBudgetBreakdown(applicationProjectDTO.getBudgetBreakdown());
        charityProject.setState(0);
        SimpleDateFormat format = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss z", Locale.US);
        charityProject.setAddTime((format.parse(applicationProjectDTO.getStartingTime().split(Pattern.quote(SPLIT_STRING))[0].replace(REPLACE_STRING[0], REPLACE_STRING[1]))));
        charityProject.setStartingTime((format.parse(applicationProjectDTO.getStartingTime().split(Pattern.quote(SPLIT_STRING))[0].replace(REPLACE_STRING[0], REPLACE_STRING[1]))));
        charityProject.setEndingTime((format.parse(applicationProjectDTO.getEndingTime().split(Pattern.quote(SPLIT_STRING))[0].replace(REPLACE_STRING[0], REPLACE_STRING[1]))));
        if(charityProjectService.addCharityProject(charityProject)){
//            System.out.println("succss");
        }
        return true;
    }

    //新增留言
    @RequestMapping(value = "/addProMessage",method = RequestMethod.POST)
    public boolean addProMessage(@Validated @RequestBody Message message){
        return charityProjectService.addProMessage(message);
    }

    //删除留言
    @RequestMapping(value = "/delProMessage",method = RequestMethod.GET)
    public boolean delProMessage(@RequestParam int messageId){
        return charityProjectService.delProMessageById(messageId);
    }

    //查看留言
    @RequestMapping(value = "/getMessagesByProjectId",method = RequestMethod.GET)
    public List<MessageDTO> getMessagesByProjectId(@RequestParam int projectId){
        return  charityProjectService.getMessagesByProjectId(projectId);
    }
    //新增留言回复
    @RequestMapping(value = "/addProMessageReply",method = RequestMethod.POST)
    public boolean addProMessageReply(@Validated @RequestBody MessageReply messageReply){
        return charityProjectService.addProMessageReply(messageReply);
    }

    //删除一条留言回复
    @RequestMapping(value = "/delProMessageReply",method = RequestMethod.GET)
    public boolean delProMessageReply(@RequestParam int replyId){
        return charityProjectService.delReplyByMessageId(replyId);
    }

    //查看留言回复
    @RequestMapping(value = "/showProMessageReply",method = RequestMethod.GET)
    public List<MessageReplyDTO> showProMessageReply(@RequestParam int messageId){
        return charityProjectService.getReplyByMessageId(messageId);
    }

    //获取后台首页信息
    @RequestMapping(value = "/getBackHome",method = RequestMethod.GET)
    public BackHomeDTO getBackHome(){
        List<HomeTotalDTO> homeTotalDTOList=new ArrayList<>();

        HomeTotalDTO homeTotalDTO1=new HomeTotalDTO();
        homeTotalDTO1.setTitle("平台善款总额");
        homeTotalDTO1.setValue(charityProjectService.getAllRaisedFunds());
        homeTotalDTOList.add(homeTotalDTO1);

        HomeTotalDTO homeTotalDTO2=new HomeTotalDTO();
        homeTotalDTO2.setTitle("预期善款总额");
        homeTotalDTO2.setValue(charityProjectService.getBudgetFunds());
        homeTotalDTOList.add(homeTotalDTO2);

        HomeTotalDTO homeTotalDTO3=new HomeTotalDTO();
        homeTotalDTO3.setTitle("待使用善款");
        homeTotalDTO3.setValue(charityProjectService.getSurplusFunds());
        homeTotalDTOList.add(homeTotalDTO3);

        HomeTotalDTO homeTotalDTO4=new HomeTotalDTO();
        homeTotalDTO4.setTitle("已使用善款");
        homeTotalDTO4.setValue(charityProjectService.getUsedFunds());
        homeTotalDTOList.add(homeTotalDTO4);

        List<HomeDetailItemDTO> homeDetailItemDTOList=new ArrayList<>();
        HomeDetailItemDTO homeDetailItemDTO=new HomeDetailItemDTO();

        HomeDetailItemDTO homeDetailItemDTO1=new HomeDetailItemDTO();
        homeDetailItemDTO1.setName("注册用户数");
        homeDetailItemDTO1.setValue(charityProjectService.getAllUsersNum());
        homeDetailItemDTO1.setColor("rgb(236, 64, 122)");
        homeDetailItemDTOList.add(homeDetailItemDTO1);

        HomeDetailItemDTO homeDetailItemDTO2=new HomeDetailItemDTO();
        homeDetailItemDTO2.setName("人均捐款额");
        homeDetailItemDTO2.setValue(new Double(charityProjectService.getDonationAverage()).intValue());
        homeDetailItemDTO2.setColor("rgb(171, 71, 188)");
        homeDetailItemDTOList.add(homeDetailItemDTO2);

        HomeDetailItemDTO homeDetailItemDTO3=new HomeDetailItemDTO();
        homeDetailItemDTO3.setName("慈善项目量");
        homeDetailItemDTO3.setValue(charityProjectService.AllProjectsNum());
        homeDetailItemDTO3.setColor("rgb(33, 150, 243)");
        homeDetailItemDTOList.add(homeDetailItemDTO3);

        HomeDetailItemDTO homeDetailItemDTO4=new HomeDetailItemDTO();
        homeDetailItemDTO4.setName("帮助用户量");
        homeDetailItemDTO4.setValue(charityProjectService.getHelpUsers());
        homeDetailItemDTO4.setColor("rgb(0, 150, 136)");
        homeDetailItemDTOList.add(homeDetailItemDTO4);

        List<HomeRankListDTO> homeRankListDTOArrayList=charityProjectService.getTopUser();

        BackHomeDTO backHomeDTO=new BackHomeDTO();
        backHomeDTO.setHomeTotalDTOS(homeTotalDTOList);
        backHomeDTO.setHomeDetailItemDTOS(homeDetailItemDTOList);
        backHomeDTO.setHomeRankListDTOS(homeRankListDTOArrayList);


        return backHomeDTO;
    }

    //最近六个月项目情况
    @RequestMapping(value = "/getSixMonth",method = RequestMethod.GET)
    public SixMonthDTO getSixMonth(){
        SixMonthDTO sixMonthDTO=new SixMonthDTO();
        sixMonthDTO.setNums(charityProjectService.getSixMonthNums());
        sixMonthDTO.setRaised(charityProjectService.getSixMonthRaised());
        sixMonthDTO.setUsed(charityProjectService.getSixMonthUsed());
        return  sixMonthDTO;
    }
    //捐款参与
    @RequestMapping(value = "/getDonationNums",method = RequestMethod.GET)
    public List<DonationNumsDTO> getDonationNums(){
        List<DonationNumsDTO> donationNumsDTOS=new ArrayList<>();
        DonationNumsDTO donationNumsDTO1=new DonationNumsDTO();
        donationNumsDTO1.setName("1-3次");
        donationNumsDTO1.setValue(charityProjectService.getDonationNums(1,3));

        DonationNumsDTO donationNumsDTO2=new DonationNumsDTO();
        donationNumsDTO2.setName("4-6次");
        donationNumsDTO2.setValue(charityProjectService.getDonationNums(4,6));

        DonationNumsDTO donationNumsDTO3=new DonationNumsDTO();
        donationNumsDTO3.setName("7-12次");
        donationNumsDTO3.setValue(charityProjectService.getDonationNums(7,12));

        DonationNumsDTO donationNumsDTO4=new DonationNumsDTO();
        donationNumsDTO4.setName("12次以上");
        donationNumsDTO4.setValue(charityProjectService.getDonationNums(13,0));

        donationNumsDTOS.add(donationNumsDTO1);
        donationNumsDTOS.add(donationNumsDTO2);
        donationNumsDTOS.add(donationNumsDTO3);
        donationNumsDTOS.add(donationNumsDTO4);


        return donationNumsDTOS;
    }

    @RequestMapping(value = "/getDonationnRatio",method = RequestMethod.GET)
    public List<DonationNumsDTO> getDonationnRatio(){
        List<DonationNumsDTO> donationNumsDTOS=new ArrayList<>();
        DonationNumsDTO donationNumsDTO1=new DonationNumsDTO();
        donationNumsDTO1.setName("1万元以下");
        donationNumsDTO1.setValue(charityProjectService.getDonationRatio(0,10000));

        DonationNumsDTO donationNumsDTO2=new DonationNumsDTO();
        donationNumsDTO2.setName("1-10万");
        donationNumsDTO2.setValue(charityProjectService.getDonationRatio(10000,100000));

        DonationNumsDTO donationNumsDTO3=new DonationNumsDTO();
        donationNumsDTO3.setName("10-40万");
        donationNumsDTO3.setValue(charityProjectService.getDonationRatio(100000,400000));

        DonationNumsDTO donationNumsDTO4=new DonationNumsDTO();
        donationNumsDTO4.setName("40万以上");
        donationNumsDTO4.setValue(charityProjectService.getDonationRatio(400000,0));

        donationNumsDTOS.add(donationNumsDTO1);
        donationNumsDTOS.add(donationNumsDTO2);
        donationNumsDTOS.add(donationNumsDTO3);
        donationNumsDTOS.add(donationNumsDTO4);


        return donationNumsDTOS;
    }

    @RequestMapping(value = "/addProTask",method = RequestMethod.POST)
    public boolean addProTask(@Validated @RequestBody TaskDTO taskDTO){
        return charityProjectService.addProTask(taskDTO);
    }

    @RequestMapping(value = "/getTaskByUserId",method = RequestMethod.POST)
    public TaskByUserIdDTO  getTaskByUserId(@Validated @RequestBody TaskPageDTO taskPageDTO){
        taskPageDTO.setPage(taskPageDTO.getPage()*taskPageDTO.getPageSize());
        TaskByUserIdDTO taskByUserIdDTO=new TaskByUserIdDTO();
        taskByUserIdDTO.setCharityProjects(charityProjectService.getTaskByUserId(taskPageDTO));
        taskByUserIdDTO.setTotal(charityProjectService.getTaskNumByUserId(taskPageDTO.getUserId()));
        return taskByUserIdDTO;
    }

    @RequestMapping(value = "/updateProTask",method = RequestMethod.POST)
    public boolean updateProTask(@Validated @RequestBody UpdateTaskDTO updateTaskDTO){
        return charityProjectService.updateProTask(updateTaskDTO);
    }

    @RequestMapping(value = "/getTaskProcess",method = RequestMethod.GET)
    public List<TaskProcessDTO>  getTaskProcess(@RequestParam int projectId){
        return charityProjectService.getTaskProcess(projectId);
    }

    @RequestMapping(value = "/recommendProjectsByCategoryId",method = RequestMethod.GET)
    public List<CharityProject>  recommendProjectsByCategoryId(@RequestParam int categoryId){
        return charityProjectService.recommendProjectsByCategoryId(categoryId);
    }
}
