package com.example.demo.dto;

import java.util.List;

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
