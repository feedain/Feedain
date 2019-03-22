package oi.feedain.backend.models.rest;

import oi.feedain.backend.models.Feedback;

public class RateFeedbackRequest {
    private Feedback feedback;

    private String rating;

    public Feedback getFeedback() {
        return this.feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
