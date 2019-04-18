package oi.feedain.backend.services;

import oi.feedain.backend.models.Feedback;
import oi.feedain.backend.models.rest.FeedbackRequest;
import oi.feedain.backend.models.rest.RateFeedbackRequest;

import java.util.List;

public interface FeedbackService {
    Feedback createFeedback(FeedbackRequest feedbackRequest);

    Feedback getFeedback(Long id);

    Feedback updateFeedback(FeedbackRequest feedbackRequest);

    boolean deleteFeedback(FeedbackRequest feedbackRequest);

    Feedback rateFeedback(RateFeedbackRequest rateFeedbackRequest);

    List<Feedback> getAllFeedback();
}
