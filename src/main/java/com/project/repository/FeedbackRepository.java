package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.models.Feedback;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

}
