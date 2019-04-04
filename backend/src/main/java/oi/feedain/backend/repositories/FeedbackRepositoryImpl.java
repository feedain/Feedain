package oi.feedain.backend.repositories;

import oi.feedain.backend.models.Feedback;
import oi.feedain.backend.models.rest.FeedbackRequest;
import oi.feedain.backend.models.rest.RateFeedbackRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeedbackRepositoryImpl implements FeedbackRepository {
    private List<Feedback> feedbackList;

    public FeedbackRepositoryImpl() {
        this.feedbackList = new ArrayList<>();
    }

    @Override
    public Feedback createFeedback(FeedbackRequest feedbackRequest) {
        Feedback feedback = new Feedback((long) (this.feedbackList.size() + 1), feedbackRequest.getFeedbackTaker(), feedbackRequest.getFeedbackGiver(), feedbackRequest.getFeedbackText());
        this.feedbackList.add(feedback);

        return feedback;
    }

    @Override
    public Feedback getFeedback(Long id) {
        return this.feedbackList.stream().filter(feedback -> feedback.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Feedback updateFeedback(FeedbackRequest feedbackRequest) {
        Feedback feedback = this.getFeedback(feedbackRequest.getId());

        if (feedback != null) {
            feedback.setFeedbackTaker(feedbackRequest.getFeedbackTaker());
            feedback.setFeedbackGiver(feedbackRequest.getFeedbackGiver());
            feedback.setFeedbackText(feedbackRequest.getFeedbackText());
        }

        return feedback;
    }

    @Override
    public boolean deleteFeedback(FeedbackRequest feedbackRequest) {
        Feedback feedback = this.getFeedback(feedbackRequest.getId());

        if (feedback != null) return this.feedbackList.remove(feedback);
        else return false;
    }

    @Override
    public Feedback rateFeedback(RateFeedbackRequest rateFeedbackRequest) {
        Feedback originalFeedback = this.getFeedback(rateFeedbackRequest.getId());
        Feedback feedback = new Feedback(originalFeedback.getFeedbackTaker(), rateFeedbackRequest.getRater(), rateFeedbackRequest.getRating());

        originalFeedback.addFeedback(feedback);

        return feedback;
    }
}
