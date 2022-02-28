package com.project.controllers;

import static com.project.encryptdecrypt.Encryption.encrypt;
import static com.project.encryptdecrypt.Encryption.createSecretKey;
import static com.project.encryptdecrypt.Encryption.decrypt;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.encryptdecrypt.Encryption.GenerateEncryptionKey;
import com.project.models.Admin;
import com.project.models.Student;
import com.project.models.Notice;
import com.project.repository.AdminRepository;
import com.project.repository.NoticeRepository;
import com.project.repository.StudentRepository;
import com.project.services.AdminServices;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class AdminController {
	
	@Autowired
    private AdminRepository adminRepository;
	@Autowired
    private AdminServices adminServices;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private NoticeRepository noticeRepository;

   
   
    @PostMapping("/admin/login")
	public List<Admin> loginAdmin(@RequestBody Admin admin) {
		System.out.println("login called");
//	    return studentRepository.save(student);
		return adminServices.loginAdmin(admin);
	}
    @GetMapping("/admin/allStudents")
    public List<Student> getAllStudents() throws GeneralSecurityException, IOException {
        
        
        return adminServices.getAllStudents();
    }
    @GetMapping("/admin/allnotices")
    public List<Notice> getAllNotices() throws GeneralSecurityException, IOException {
        
        
        return adminServices.getAllNotices();
    }

    

}
