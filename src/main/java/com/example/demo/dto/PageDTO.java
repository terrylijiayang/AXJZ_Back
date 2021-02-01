package com.example.demo.dto;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: PageDTO
 * @Description: 用作分页
 * @Author: 李佳阳
 * @CreateDate: 2020/2/18 21:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/18 21:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PageDTO {
    private int page;
    private int pageSize;

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
