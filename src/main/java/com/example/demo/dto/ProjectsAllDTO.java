package com.example.demo.dto;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: ProjectsAllDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/2/18 22:20
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/18 22:20
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ProjectsAllDTO {
    private List<UserProjectsDTO> projectsDTOList;
    private int total;

    public List<UserProjectsDTO> getProjectsDTOList() {
        return projectsDTOList;
    }

    public void setProjectsDTOList(List<UserProjectsDTO> projectsDTOList) {
        this.projectsDTOList = projectsDTOList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
