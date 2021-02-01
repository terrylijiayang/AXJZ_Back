package com.example.demo.dto;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: BackHomeDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/3/12 13:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 13:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
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
