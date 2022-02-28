package com.project.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.models.Feedback;
import com.project.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
    private FeedbackRepository feedbackRepository;
	
	public void sendFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
	}
}
