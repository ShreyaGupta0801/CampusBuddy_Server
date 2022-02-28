package com.project.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.Timetable;
import com.project.repository.TimetableRepository;
@Service
public class TimetableService {

	@Autowired
    private TimetableRepository timetableRepository;

    public List<Timetable> getTimeTable() {
        return timetableRepository.findAll();
    }
}
