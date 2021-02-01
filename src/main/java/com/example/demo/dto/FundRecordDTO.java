package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: FundRecordDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/3/12 12:02
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 12:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FundRecordDTO {
    private int fundId;
    private String fundRecordName;
    private String content;
    private Date createdAt;
    private Double fund;

    public Double getFund() {
        return fund;
    }

    public void setFund(Double fund) {
        this.fund = fund;
    }

    public int getFundId() {
        return fundId;
    }

    public void setFundId(int fundId) {
        this.fundId = fundId;
    }

    public String getFundRecordName() {
        return fundRecordName;
    }

    public void setFundRecordName(String fundRecordName) {
        this.fundRecordName = fundRecordName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
