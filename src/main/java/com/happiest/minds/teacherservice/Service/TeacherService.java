package com.happiest.minds.teacherservice.Service;

import com.happiest.minds.teacherservice.Entity.TeacherEntity;
import com.happiest.minds.teacherservice.Repository.TeacherRepository;
import com.happiest.minds.teacherservice.Entity.TeacherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    RestTemplate restTemplate;

    public TeacherEntity create(@RequestBody TeacherEntity teacherEntity) {
        return teacherRepository.save(teacherEntity);
    }

    public Optional<TeacherEntity> getTeacher(Integer id) {
        return teacherRepository.findById(id);
    }

    public TeacherEntity update(TeacherEntity teacherEntity) {
        return teacherRepository.save(teacherEntity);
    }

    public void delete(Integer id) {
        teacherRepository.deleteById(id);
    }

    public List<TeacherEntity> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
