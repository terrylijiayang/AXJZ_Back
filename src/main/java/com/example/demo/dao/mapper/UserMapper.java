package com.example.demo.dao.mapper;
import com.example.demo.dto.MyDonationDTO;
import com.example.demo.dto.PageDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public User getUserByPhone(String phone);
    public User getUserByIdentityNumber(String identityNumber);
    public int register(User user);
    public List<MyDonationDTO> myDonations(MyDonationDTO myDonationDTO);
    public int myDonationsNum(int userId);
    public List<User> getAllUser(PageDTO pageDTO);
    //注册用户量
    public int AllUsersNum();
    public int delUserById(int userId);
    public List<Role> getAllRole();
    public List<Menu> getAllMenu();
    public int delAuthorityByRoleId(int roleId);
    public int insertAuthorityByRole(Authority authority);
    public List<RoleMenu> getRoleAllMenu(int roleId);
    public int updateMenu(Menu menu);
    public List<Integer> listByRoleId(int roleId);
    public int updateUser(UserDTO userDTO);
    //获取管理员及以上
    public List<User> getAdminUsers();

}