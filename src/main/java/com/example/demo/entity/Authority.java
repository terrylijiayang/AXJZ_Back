package com.example.demo.entity;

import java.util.List;

public class Authority {
    private int roleId;
    private List<Integer> selectList;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getSelectList() {
        return selectList;
    }

    public void setSelectList(List<Integer> selectList) {
        this.selectList = selectList;
    }
}
