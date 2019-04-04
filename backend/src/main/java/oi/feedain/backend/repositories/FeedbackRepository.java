package oi.feedain.backend.repositories;

import oi.feedain.backend.models.Feedback;
import oi.feedain.backend.models.rest.FeedbackRequest;
import oi.feedain.backend.models.rest.RateFeedbackRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository {
    Feedback createFeedback(FeedbackRequest feedbackRequest);

    Feedback getFeedback(Long id);

    Feedback updateFeedback(FeedbackRequest feedbackRequest);

    boolean deleteFeedback(FeedbackRequest feedbackRequest);

    Feedback rateFeedback(RateFeedbackRequest rateFeedbackRequest);
}
