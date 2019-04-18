package oi.feedain.backend.services;

import oi.feedain.backend.models.Feedback;
import oi.feedain.backend.models.rest.FeedbackRequest;
import oi.feedain.backend.models.rest.RateFeedbackRequest;
import oi.feedain.backend.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback createFeedback(FeedbackRequest feedbackRequest) {
        return this.feedbackRepository.createFeedback(feedbackRequest);
    }

    @Override
    public Feedback getFeedback(Long id) {
        return this.feedbackRepository.getFeedback(id);
    }

    @Override
    public Feedback updateFeedback(FeedbackRequest feedbackRequest) {
        return this.feedbackRepository.updateFeedback(feedbackRequest);
    }

    @Override
    public boolean deleteFeedback(FeedbackRequest feedbackRequest) {
        return this.feedbackRepository.deleteFeedback(feedbackRequest);
    }

    @Override
    public Feedback rateFeedback(RateFeedbackRequest rateFeedbackRequest) {
        return this.feedbackRepository.rateFeedback(rateFeedbackRequest);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return this.feedbackRepository.getAllFeedback();
    }


}
