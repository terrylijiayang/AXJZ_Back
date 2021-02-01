package com.example.demo.dto;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: HomeRankListDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/3/12 13:28
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 13:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HomeRankListDTO {
    private String name;
    private Double value;
    private String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
