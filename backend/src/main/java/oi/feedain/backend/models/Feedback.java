package oi.feedain.backend.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Feedback {
    private Long id;

    private UserBase feedbackTaker;

    private UserBase feedbackGiver;

    private String feedbackText;

    private List<Feedback> feedbackList;

    public Feedback() {
        this.feedbackList = new ArrayList<>();
    }

    public Feedback(UserBase feedbackTaker, UserBase feedbackGiver, String feedbackText) {
        this();

        this.feedbackTaker = feedbackTaker;
        this.feedbackGiver = feedbackGiver;
        this.feedbackText = feedbackText;
    }

    public Feedback(Long id, UserBase feedbackTaker, UserBase feedbackGiver, String feedbackText) {
        this(feedbackTaker, feedbackGiver, feedbackText);

        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

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

    public void addFeedback(Feedback feedback) {
        this.feedbackList.add(feedback);
    }

    public List<Feedback> getFeedbackList() {
        return Collections.unmodifiableList(this.feedbackList);
    }
}
