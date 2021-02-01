package com.example.demo.dto;

import java.util.List;

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
