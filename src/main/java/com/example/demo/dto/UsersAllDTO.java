package com.example.demo.dto;

import com.example.demo.entity.User;

import java.util.List;


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
