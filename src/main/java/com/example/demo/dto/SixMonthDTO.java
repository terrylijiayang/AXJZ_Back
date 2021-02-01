package com.example.demo.dto;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: SixMonthDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/3/12 18:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 18:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SixMonthDTO {
    private List<Integer> nums;
    private List<Double> raised;
    private List<Double> used;

    public List<Integer> getNums() {
        return nums;
    }

    public void setNums(List<Integer> nums) {
        this.nums = nums;
    }

    public List<Double> getRaised() {
        return raised;
    }

    public void setRaised(List<Double> raised) {
        this.raised = raised;
    }

    public List<Double> getUsed() {
        return used;
    }

    public void setUsed(List<Double> used) {
        this.used = used;
    }
}
