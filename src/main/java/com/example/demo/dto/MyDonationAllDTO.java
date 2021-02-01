package com.example.demo.dto;

import com.example.demo.entity.Category;
import com.example.demo.entity.DonationRecord;

import java.util.List;

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
