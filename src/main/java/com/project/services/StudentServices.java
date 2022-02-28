package com.project.services;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
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

import com.project.exceptionhandling.NotFoundException;
import com.project.models.Feedback;
import com.project.models.Notice;
import com.project.models.Student;
import com.project.models.Timetable;
import com.project.repository.StudentRepository;
import com.project.repository.TimetableRepository;
import com.project.repository.FeedbackRepository;
import com.project.repository.NoticeRepository;


@Service
public class StudentServices {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TimetableRepository timetableRepository;
	@Autowired
	private FeedbackRepository feedbackRepository;
	@Autowired
	private NoticeRepository noticeRepository;

	

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	
	public Student createStudent(@RequestBody Student student) {
		
		return studentRepository.save(student);
	}
	public List<Student> loginStudent(@RequestBody Student student) {
		System.out.println("login called");

		return studentRepository.findByEmailAndPassword(student.getEmail(), student.getPassword());
	}
	public List<Timetable> getSchedule() {
		System.out.println("timetable");
		return timetableRepository.findAll();
	}
	public Feedback createFeedback(@RequestBody Feedback feedback) {
		return feedbackRepository.save(feedback);
	}
	public List<Notice> getNotices() {
		System.out.println("all notice hit");
		return noticeRepository.findAll();
	}
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id) throws UnsupportedEncodingException, GeneralSecurityException{
		Student student = studentRepository.findById(id).orElseThrow(()->new NotFoundException("Student not found"));
				

		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent)
			throws UnsupportedEncodingException, GeneralSecurityException {
		
		Student student = studentRepository.findById(id).orElseThrow(()->new NotFoundException("Student not found"));
		student.setName(updatedStudent.getName());
		student.setEmail(updatedStudent.getEmail());

//		SecretKeySpec updatedEncryptkey = createSecretKey(updatedStudent.getPassword().toCharArray(),
//				GenerateEncryptionKey.salt,
//				GenerateEncryptionKey.iterationCount, GenerateEncryptionKey.keyLength);
//		//student.setEncryptKey(updatedEncryptkey);
//		//String encryptedPass = encrypt(updatedStudent.getPassword(), updatedEncryptkey);
//		//student.setPassword(encryptedPass);

		student.setEnroll(updatedStudent.getEnroll());
		student.setBranch(updatedStudent.getBranch());
		student.setSemester(updatedStudent.getSemester());
		student.setContactNo(updatedStudent.getContactNo());

		studentRepository.save(student);
		return ResponseEntity.ok(student);
	}

	

}
