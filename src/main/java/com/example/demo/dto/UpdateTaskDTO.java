package com.example.demo.dto;

import java.util.Date;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: UpdateTaskDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/3/13 23:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/13 23:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UpdateTaskDTO {
    private int projectId;
    private int userId;
    private int state;
    private Date createdAt;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
