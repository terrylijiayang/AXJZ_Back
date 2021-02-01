package com.example.demo.dto;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: TaskDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/3/13 21:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/13 21:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TaskDTO {
    private int projectId;
    private List<Integer> userValue;
    private Date createdAt;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public List<Integer> getUserValue() {
        return userValue;
    }

    public void setUserValue(List<Integer> userValue) {
        this.userValue = userValue;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
