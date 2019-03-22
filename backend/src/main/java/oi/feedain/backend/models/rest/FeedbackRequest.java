package oi.feedain.backend.models.rest;

import oi.feedain.backend.models.UserBase;

public class FeedbackRequest {
    private UserBase feedbackTaker;

    private UserBase feedbackGiver;

    private String feedbackText;

    public UserBase getFeedbackTaker() {
        return this.feedbackTaker;
    }

    public void setFeedbackTaker(UserBase feedbackTaker) {
        this.feedbackTaker = feedbackTaker;
    }

    public UserBase getFeedbackGiver() {
        return this.feedbackGiver;
    }

    public void setFeedbackGiver(UserBase feedbackGiver) {
        this.feedbackGiver = feedbackGiver;
    }

    public String getFeedbackText() {
        return this.feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }
}
