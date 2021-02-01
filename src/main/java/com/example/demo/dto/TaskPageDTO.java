package com.example.demo.dto;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: TaskPageDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/3/14 12:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/14 12:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TaskPageDTO {
    private int page;
    private int pageSize;
    private int userId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
