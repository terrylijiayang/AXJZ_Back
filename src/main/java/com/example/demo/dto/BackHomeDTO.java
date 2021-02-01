package com.example.demo.dto;

import java.util.List;

public class BackHomeDTO {
    private List<HomeTotalDTO> homeTotalDTOS;
    private List<HomeRankListDTO> homeRankListDTOS;
    private List<HomeDetailItemDTO> homeDetailItemDTOS;

    public List<HomeTotalDTO> getHomeTotalDTOS() {
        return homeTotalDTOS;
    }

    public void setHomeTotalDTOS(List<HomeTotalDTO> homeTotalDTOS) {
        this.homeTotalDTOS = homeTotalDTOS;
    }

    public List<HomeRankListDTO> getHomeRankListDTOS() {
        return homeRankListDTOS;
    }

    public void setHomeRankListDTOS(List<HomeRankListDTO> homeRankListDTOS) {
        this.homeRankListDTOS = homeRankListDTOS;
    }

    public List<HomeDetailItemDTO> getHomeDetailItemDTOS() {
        return homeDetailItemDTOS;
    }

    public void setHomeDetailItemDTOS(List<HomeDetailItemDTO> homeDetailItemDTOS) {
        this.homeDetailItemDTOS = homeDetailItemDTOS;
    }
}
