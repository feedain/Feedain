package oi.feedain.backend.models.rest;

import oi.feedain.backend.models.RegularUser;
import oi.feedain.backend.models.UserBase;

public class FeedbackRequest {
    private Long id;

    private UserBase feedbackTaker;

    private UserBase feedbackGiver;

    private String feedbackText;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserBase getFeedbackTaker() {
        return this.feedbackTaker;
    }

    public void setFeedbackTaker(RegularUser feedbackTaker) {
        this.feedbackTaker = feedbackTaker;
    }

    public UserBase getFeedbackGiver() {
        return this.feedbackGiver;
    }

    public void setFeedbackGiver(RegularUser feedbackGiver) {
        this.feedbackGiver = feedbackGiver;
    }

    public String getFeedbackText() {
        return this.feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }
}
