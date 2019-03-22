package oi.feedain.backend.controllers;

import oi.feedain.backend.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/feedback")
public class FeedbackController {
    private FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping(value = "", produces = { "application/json" })
    public ResponseEntity createFeedback() {
        throw new UnsupportedOperationException("To be implemented");
    }

    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity getFeedback(@PathVariable("id") Long id) {
        throw new UnsupportedOperationException("To be implemented");
    }

    @PostMapping(value = "", produces = { "application/json" })
    public ResponseEntity updateFeedback() {
        throw new UnsupportedOperationException("To be implemented");
    }

    @DeleteMapping(value = "", produces = { "application/json" })
    public ResponseEntity deleteFeedback() {
        throw new UnsupportedOperationException("To be implemented");
    }

    @PostMapping(value = "/rate", produces = { "application/json" })
    public ResponseEntity rateFeedback() {
        throw new UnsupportedOperationException("To be implemented");
    }
}
