package com.project.controllers;

import static com.project.encryptdecrypt.Encryption.createSecretKey;
import static com.project.encryptdecrypt.Encryption.decrypt;
import static com.project.encryptdecrypt.Encryption.encrypt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.crypto.spec.SecretKeySpec;

import com.project.encryptdecrypt.Encryption.GenerateEncryptionKey;
import com.project.exceptionhandling.NotFoundException;
import com.project.models.Feedback;
import com.project.models.Notice;
import com.project.models.Student;
import com.project.models.Timetable;
import com.project.repository.FeedbackRepository;
import com.project.repository.NoticeRepository;
import com.project.repository.StudentRepository;
import com.project.repository.TimetableRepository;
import com.project.services.FeedbackService;
import com.project.services.NoticeService;
import com.project.services.StudentServices;
import com.project.services.TimetableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")

public class StudentController {

	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentServices studentServices;
	@Autowired
	private TimetableService timetableService;
	@Autowired
	private FeedbackService feedbackService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private FeedbackRepository feedbackRepository;
	@Autowired
	private NoticeRepository noticeRepository;



	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		System.out.println("in get method");
		List<Student> list = studentServices.getAllStudents();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
 

	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student)
			throws GeneralSecurityException, IOException {
		System.out.println(student.getPassword());
		String password = student.getPassword();

		/*SecretKeySpec encryptKey = createSecretKey(password.toCharArray(), GenerateEncryptionKey.salt,
				GenerateEncryptionKey.iterationCount, GenerateEncryptionKey.keyLength);
		student.setEncryptKey(encryptKey);

		String encryptedPass = encrypt(password, encryptKey);
		student.setPassword(encryptedPass);*/

		return studentServices.createStudent(student);
	}
	
	@PostMapping("/student/login")
	public List<Student> loginStudent(@RequestBody Student student) {
		return studentServices.loginStudent(student);
	}
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent)
			throws UnsupportedEncodingException, GeneralSecurityException {
		
		
		return studentServices.updateStudent(id,updatedStudent);
	}
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id) throws UnsupportedEncodingException, GeneralSecurityException{
		return studentServices.deleteStudent(id);
	}
	
	@GetMapping("/student/timetable")
	public List<Timetable> getTimeTable() {
		
		return timetableService.getTimeTable();
	}

	@PostMapping("/student/feedback")
	public void sentFeedback(@RequestBody Feedback feedback) {
		feedbackService.sendFeedback(feedback);
	}
	@GetMapping("/student/notices")
	public List<Notice> getNotices() {
		return noticeService.getNotices();
	}

}
