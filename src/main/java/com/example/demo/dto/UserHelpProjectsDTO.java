package com.example.demo.dto;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: UserHelpProjectsDTO
 * @Description: 用户申请项目
 * @Author: 李佳阳
 * @CreateDate: 2020/2/19 14:38
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/19 14:38
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UserHelpProjectsDTO {
    private int userId;
    private int page;
    private int pageSize;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
