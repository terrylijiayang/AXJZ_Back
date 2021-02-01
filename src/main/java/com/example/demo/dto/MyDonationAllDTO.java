package com.example.demo.dto;

import com.example.demo.entity.Category;
import com.example.demo.entity.DonationRecord;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: MyDonationDTO
 * @Description: 用户捐赠的信息
 * @Author: 李佳阳
 * @CreateDate: 2020/2/21 16:49
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/21 16:49
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyDonationAllDTO {
    private  List<MyDonationDTO> myDonationDTOList;
    private int total;

    public List<MyDonationDTO> getMyDonationDTOList() {
        return myDonationDTOList;
    }

    public void setMyDonationDTOList(List<MyDonationDTO> myDonationDTOList) {
        this.myDonationDTOList = myDonationDTOList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
