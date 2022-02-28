package com.project.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.models.Timetable;

@Repository
public interface TimetableRepository  extends JpaRepository<Timetable, Long>{

	

}
