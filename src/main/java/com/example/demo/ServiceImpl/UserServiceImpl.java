package com.example.demo.ServiceImpl;

import com.example.demo.Service.UserService;
import com.example.demo.dao.mapper.UserMapper;
import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.MyDonationDTO;
import com.example.demo.dto.PageDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserMapper userMapper;
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    @Override
    public User getUserByPhone(String phone){
        User user = userMapper.getUserByPhone(phone);
        return user;
    }

    @Override
    public User getUserByIdentityNumber(String identityNumber) {
        User user = userMapper.getUserByIdentityNumber(identityNumber);
        return user;
    }

    @Override
    public String register(User user) {
      /*  if(getUserByPhone(user.getPhone()) != null)
            return "用户已存在";
        else if(getUserByIdentityNumber(user.getIdentityNumber()) != null)
            return "用户已存在";*/
      if(userMapper.register(user) >= 0)
            return "注册成功";
        else
            return "注册失败";
    }

    @Override
    public List<MyDonationDTO> myDonations(MyDonationDTO myDonationDTO) {
        return userMapper.myDonations(myDonationDTO);
    }

    @Override
    public int myDonationsNum(int userId) {
        return userMapper.myDonationsNum(userId);
    }

    @Override
    public List<User> getAllUser(PageDTO pageDTO) {
        return userMapper.getAllUser(pageDTO);
    }

    @Override
    public int AllUsersNum() {
        return userMapper.AllUsersNum();
    }

    @Override
    public boolean delUserById(int userId) {
        return userMapper.delUserById(userId)>0?true:false;
    }


    @Override
    public List<Menu> getAllMenu() {
        return userMapper.getAllMenu();
    }

    @Override
    public List<RoleMenu> getRoleAllMenu(int roleId) {
        return userMapper.getRoleAllMenu(roleId);
    }

    @Override
    public boolean updateMenu(Menu menu) {
        return userMapper.updateMenu(menu)>0? true:false;
    }

    @Override
    public List<Role> getAllRole() {
        return userMapper.getAllRole();
    }

    @Override
    public boolean updateMenuByRoleId(Authority authority) {
        //删除之前的权限
        userMapper.delAuthorityByRoleId(authority.getRoleId());
        if(authority.getSelectList().size()==0){
            return true;
        }else{
            return userMapper.insertAuthorityByRole(authority)>0?true:false;
        }

    }

    @Override
    public List<Integer> listByRoleId(int roleId) {
        return userMapper.listByRoleId(roleId);
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return userMapper.updateUser(userDTO)>0?true:false;
    }

    @Override
    public List<User> getAdminUsers() {
        return userMapper.getAdminUsers();
    }
}
