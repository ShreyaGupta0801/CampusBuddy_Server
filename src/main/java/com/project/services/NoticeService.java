package com.project.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.models.Notice;
import com.project.repository.FeedbackRepository;
import com.project.repository.NoticeRepository;

@Service
public class NoticeService {
	
	@Autowired
    private NoticeRepository noticeRepository;
	public List<Notice> getNotices() {
		System.out.println("all notice hit");
		return noticeRepository.findAll();
	}

}
