package com.project.services;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.models.Admin;
import com.project.models.Feedback;
import com.project.models.Notice;
import com.project.models.Student;
import com.project.models.Timetable;
import com.project.repository.StudentRepository;
import com.project.repository.TimetableRepository;
import com.project.repository.AdminRepository;
import com.project.repository.FeedbackRepository;
import com.project.repository.NoticeRepository;

@Service
public class AdminServices {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TimetableRepository timetableRepository;
	@Autowired
	private FeedbackRepository feedbackRepository;
	@Autowired
	private NoticeRepository noticeRepository;
	
	public List<Admin> loginAdmin(@RequestBody Admin admin) {
		return adminRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword());
	}
	public List<Student> getAllStudents(){
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}
	public List<Notice> getAllNotices() {
		List<Notice> noticeList = noticeRepository.findAll();
		return noticeList;
	}
	
		
}
