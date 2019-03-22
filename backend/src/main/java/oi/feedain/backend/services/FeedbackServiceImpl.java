package oi.feedain.backend.services;

import oi.feedain.backend.models.Feedback;
import oi.feedain.backend.models.rest.FeedbackRequest;
import oi.feedain.backend.models.rest.RateFeedbackRequest;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Override
    public Feedback createFeedback(FeedbackRequest feedbackRequest) {
        throw new UnsupportedOperationException("createFeedback gets implemented when the blockchain is working");
    }

    @Override
    public Feedback getFeedback(Long id) {
        throw new UnsupportedOperationException("getFeedback gets implemented when the blockchain is working");
    }

    @Override
    public Feedback updateFeedback(FeedbackRequest feedbackRequest) {
        throw new UnsupportedOperationException("updateFeedback gets implemented when the blockchain is working");
    }

    @Override
    public boolean deleteFeedback(FeedbackRequest feedbackRequest) {
        throw new UnsupportedOperationException("deleteFeedback gets implemented when the blockchain is working");
    }

    @Override
    public Feedback rateFeedback(RateFeedbackRequest rateFeedbackRequest) {
        throw new UnsupportedOperationException("rateFeedback gets implemented when the blockchain is working");
    }
}
