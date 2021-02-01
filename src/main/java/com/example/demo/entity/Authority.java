package com.example.demo.entity;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.entity
 * @ClassName: Authority
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/3/10 14:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/10 14:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
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
