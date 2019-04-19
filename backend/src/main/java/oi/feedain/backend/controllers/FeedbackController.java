package oi.feedain.backend.controllers;

import oi.feedain.backend.models.Feedback;
import oi.feedain.backend.models.rest.FeedbackRequest;
import oi.feedain.backend.models.rest.RateFeedbackRequest;
import oi.feedain.backend.models.rest.Response;
import oi.feedain.backend.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/feedback")
public class FeedbackController {
    private FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @CrossOrigin
    @PostMapping(value = "", produces = { "application/json" })
    public ResponseEntity<Response> createFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        Feedback feedback = this.feedbackService.createFeedback(feedbackRequest);

        if (feedback == null) return new ResponseEntity<>(new Response("Failed to create feedback", null), HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(new Response("Feedback created successfully", feedback), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity getFeedback(@PathVariable("id") Long id) {
        Feedback feedback = this.feedbackService.getFeedback(id);

        if (feedback == null) return new ResponseEntity<>(new Response("Failed to get feedback", null), HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(new Response(feedback), HttpStatus.OK);
    }

    @PutMapping(value = "", produces = { "application/json" })
    public ResponseEntity updateFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        Feedback feedback = this.feedbackService.updateFeedback(feedbackRequest);

        if (feedback == null) return new ResponseEntity<>(new Response("Failed to update feedback", null), HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(new Response("Feedback changed successfully", feedback), HttpStatus.OK);
    }

    @DeleteMapping(value = "", produces = { "application/json" })
    public ResponseEntity deleteFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        boolean deleted = this.feedbackService.deleteFeedback(feedbackRequest);

        if (!deleted) return new ResponseEntity<>(new Response("Failed to delete feedback", false), HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(new Response("Deleted feedback successfully", true), HttpStatus.OK);
    }

    @PostMapping(value = "/rate", produces = { "application/json" })
    public ResponseEntity rateFeedback(@RequestBody RateFeedbackRequest rateFeedbackRequest) {
        Feedback feedback = this.feedbackService.rateFeedback(rateFeedbackRequest);

        if (feedback == null) return new ResponseEntity<>(new Response("Failed to rate the feedback", null), HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(new Response("Rated feedback successfully", feedback), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping(value = "/all", produces = { "application/json" })
    public ResponseEntity getAllFeedback() {
        List<Feedback> feedbackList = this.feedbackService.getAllFeedback();

        if (feedbackList.isEmpty()) return new ResponseEntity<>(new Response("No feedback found", feedbackList), HttpStatus.OK);
        else return new ResponseEntity<>(new Response(feedbackList), HttpStatus.OK);
    }
}
