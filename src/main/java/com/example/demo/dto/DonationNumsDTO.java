package com.example.demo.dto;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: DonationNumsDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/3/12 19:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 19:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DonationNumsDTO {
    private String name;
    private double value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
