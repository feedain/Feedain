package oi.feedain.backend.models.rest;

import oi.feedain.backend.models.RegularUser;
import oi.feedain.backend.models.UserBase;

public class RateFeedbackRequest {
    private Long id;

    private UserBase rater;

    private String rating;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserBase getRater() {
        return this.rater;
    }

    public void setRater(RegularUser rater) {
        this.rater = rater;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
