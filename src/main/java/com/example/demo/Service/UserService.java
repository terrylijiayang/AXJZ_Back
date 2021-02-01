package com.example.demo.Service;
import com.example.demo.dto.MyDonationDTO;
import com.example.demo.dto.PageDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.*;

import java.util.List;

public interface UserService {
    public User getUserByPhone(String phone);
    public User getUserByIdentityNumber(String identityNumber);
    public String register(User user);
    //用户捐赠的项目
    public List<MyDonationDTO> myDonations(MyDonationDTO myDonationDTO);
    public int myDonationsNum(int userId);
    //获取所有用户
    public List<User> getAllUser(PageDTO pageDTO);
    public int AllUsersNum();
    //刪除用户
    public boolean delUserById(int userId);
    //获取菜单
    public List<Menu> getAllMenu();
    //获取角色权限菜单
    public List<RoleMenu> getRoleAllMenu(int roleId);
    //修改菜单
    public boolean updateMenu(Menu menu);
    //获取角色
    public List<Role>getAllRole();
    //更新角色权限
    public boolean updateMenuByRoleId(Authority authority);
    //获取角色权限
    public List<Integer> listByRoleId(int roleId);
    //修改用户信息
    public boolean updateUser(UserDTO userDTO);
    //管理员用户信息
    public List<User> getAdminUsers();
}
