package com.example.demo.dao.mapper;

import com.example.demo.dto.HomeRankListDTO;
import com.example.demo.entity.DonationRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DonationRecordMapper {
    public int addDonationRecord(DonationRecord donationRecord);
    public int updateDonationRecord(DonationRecord donationRecord);
    public List<DonationRecord> getDonationRecordByUserId(int userId);
    public DonationRecord getDonationRecordByUserIdAndProjectId(@Param("userId") int userId, @Param("projectId")int projectId);
    //后台首页
    public int getDonationUserNum();
    public double getDonationAverage();
    //慈善排行榜
    public List<HomeRankListDTO> getTopUser();
    //捐款参与
    public double getDonationNums(@Param(value ="start") int start,@Param(value = "end") int end);
    public double getDonationRatio(@Param(value ="start") int start,@Param(value = "end") int end);
}
