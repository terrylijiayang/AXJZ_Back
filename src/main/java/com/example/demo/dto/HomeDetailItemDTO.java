package com.example.demo.dto;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: HomeDetailItemDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/3/12 13:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 13:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HomeDetailItemDTO {
    private String name;
    private int value;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
