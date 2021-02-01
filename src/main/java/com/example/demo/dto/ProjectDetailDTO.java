package com.example.demo.dto;

import com.example.demo.entity.CharityProject;
import com.example.demo.entity.Feedback;
import com.example.demo.entity.Image;

import java.util.List;

public class ProjectDetailDTO {
    private ProjectsDTO charityProject;
    private List<Feedback> feedbacks;
    private List<FundRecordDTO> fundRecordDTOS;
    private List<Image> images;

    public List<FundRecordDTO> getFundRecordDTOS() {
        return fundRecordDTOS;
    }

    public void setFundRecordDTOS(List<FundRecordDTO> fundRecordDTOS) {
        this.fundRecordDTOS = fundRecordDTOS;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setCharityProject(ProjectsDTO charityProject) {
        this.charityProject = charityProject;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public ProjectsDTO getCharityProject() {
        return charityProject;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }
}
