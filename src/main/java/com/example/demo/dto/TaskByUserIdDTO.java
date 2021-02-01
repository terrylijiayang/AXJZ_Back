package com.example.demo.dto;

import com.example.demo.entity.CharityProject;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: TaskByUserIdDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/3/14 12:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/14 12:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TaskByUserIdDTO {
    private  int total;
    private List<CharityProject> charityProjects;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<CharityProject> getCharityProjects() {
        return charityProjects;
    }

    public void setCharityProjects(List<CharityProject> charityProjects) {
        this.charityProjects = charityProjects;
    }
}
