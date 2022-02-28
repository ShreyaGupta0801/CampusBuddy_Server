package com.project.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.models.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long>{


	 

}
