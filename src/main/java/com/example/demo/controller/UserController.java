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

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    public UserService userService;
    @Autowired
    public UploadService uploadService;
    @Autowired
    public CharityProjectService charityProjectService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public User login(@Valid String phone, String password){
        User user = userService.getUserByPhone(phone);
        if(user == null || password.equals(user.getPassword()) == false)
            return null;
        else{
            return user;
        }
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user, List<MultipartFile> files){
        for(int i = 0;i < files.size();i++){
            if(uploadService.upload(files.get(i)) == false){
                return "图片上传失败";
            }
            String avatarPath = files.get(i).getOriginalFilename();
            user.setAvatarPath(avatarPath);
        }
        return userService.register(user);
    }
    //查看我的捐赠
    @RequestMapping(value = "/myDonation",method = RequestMethod.POST)
    public MyDonationAllDTO showMyDonation(@Validated @RequestBody MyDonationDTO myDonationDTO){
        myDonationDTO.setPage(myDonationDTO.getPage()*myDonationDTO.getPageSize());
        MyDonationAllDTO myDonationAllDTO  = new MyDonationAllDTO();
        myDonationAllDTO.setMyDonationDTOList(userService.myDonations(myDonationDTO));
        myDonationAllDTO.setTotal(userService.myDonationsNum(myDonationDTO.getUserId()));
     /*   List<DonationRecord> donationRecords = charityProjectService.getDonationRecordByUserId(userId);
        List<ProjectsDTO> charityProjects = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        for(int i = 0;i < donationRecords.size();i++){
            int projectId = donationRecords.get(i).getProjectId();
            ProjectsDTO charityProject = charityProjectService.getCharityProjectById(projectId);
            charityProjects.add(charityProject);
            int categoryId = charityProject.getCategoryId();
            Category category = charityProjectService.getCategoryById(categoryId);
            categories.add(category);
        }
        MyDonationDTO myDonationDTO = new MyDonationDTO(categories,charityProjects,donationRecords);*/
        return myDonationAllDTO;
    }
    //获取用户
    @RequestMapping(value = "/getAllUser",method = RequestMethod.POST)
    public UsersAllDTO getAllUser(@Validated @RequestBody PageDTO pageDTO){
        pageDTO.setPage(pageDTO.getPage()*pageDTO.getPageSize());
        UsersAllDTO usersAllDTO = new UsersAllDTO();
        usersAllDTO.setUsers(userService.getAllUser(pageDTO));
        usersAllDTO.setTotal(userService.AllUsersNum());

        return usersAllDTO;
    }

    //刪除用户
    @RequestMapping(value = "/delUserById",method = RequestMethod.GET)
    public boolean delUserById(@RequestParam int userId){
        return userService.delUserById(userId);
    }
    //获取菜单
    @RequestMapping(value = "/getAllMenu",method = RequestMethod.GET)
    public List<Menu> getAllMenu(){
        return  userService.getAllMenu();
    }
    //获取角色权限菜单
    @RequestMapping(value = "/getRoleAllMenu",method = RequestMethod.GET)
    public List<RoleMenu> getRoleAllMenu(@RequestParam int roleId){
        return  userService.getRoleAllMenu(roleId);
    }
    //更新角色权限
    @RequestMapping(value = "/updateMenuByRoleId",method = RequestMethod.POST)
    public boolean updateMenuByRoleId(@Validated @RequestBody Authority authority){
        return userService.updateMenuByRoleId(authority);
    }
    //隐藏某个菜单
    @RequestMapping(value = "/updateMenu",method = RequestMethod.POST)
    public boolean updateMenu(@Validated @RequestBody Menu menu){
        return userService.updateMenu(menu);
    }
    //获取角色
    @RequestMapping(value = "/getAllRole",method = RequestMethod.GET)
    public List<Role> getAllRole(){
        return userService.getAllRole();
    }
    //获取角色权限
    @RequestMapping(value = "/listByRoleId",method = RequestMethod.GET)
    public List<Integer> listByRoleId(@RequestParam int roleId){
        return userService.listByRoleId(roleId);
    }
    //修改用户信息
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public boolean updateMenu(@Validated @RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }
    //获得管理员用户信息
    @RequestMapping(value = "/getAdminUsers",method = RequestMethod.GET)
    public List<User> getAdminUsers(){
        return userService.getAdminUsers();
    }

}
