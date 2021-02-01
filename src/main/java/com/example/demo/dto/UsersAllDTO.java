package com.example.demo.dto;

import com.example.demo.entity.User;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: UsersAllDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/2/23 14:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/23 14:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UsersAllDTO {
    private List<User> users;
    private int total;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
