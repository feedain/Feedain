package oi.feedain.backend.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Feedback {
    private UserBase feedbackTaker;

    private UserBase feedbackGiver;

    private String feedbackText;

    private List<Feedback> feedbackList;

    public Feedback() {
        this.feedbackList = new ArrayList<>();
    }

    public Feedback(UserBase feedbackTaker, UserBase feedbackGiver, String feedbackText) {
        super();

        this.feedbackTaker = feedbackTaker;
        this.feedbackGiver = feedbackGiver;
        this.feedbackText = feedbackText;
    }

    public UserBase getFeedbackTaker() {
        return this.feedbackTaker;
    }

    public UserBase getFeedbackGiver() {
        return this.feedbackGiver;
    }

    public String getFeedbackText() {
        return this.feedbackText;
    }

    public void addFeedback(Feedback feedback) {
        this.feedbackList.add(feedback);
    }

    public List<Feedback> getFeedbackList() {
        return Collections.unmodifiableList(this.feedbackList);
    }
}
