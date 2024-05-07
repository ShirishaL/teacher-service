package com.happiest.minds.teacherservice.Controller;

import com.happiest.minds.teacherservice.Entity.TeacherEntity;
import com.happiest.minds.teacherservice.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping
    public TeacherEntity create(@RequestBody TeacherEntity teacherEntity) {
        return teacherService.create(teacherEntity);
    }

    @GetMapping("/{id}")
    public Optional<TeacherEntity> getStudent(@PathVariable(name = "id") Integer id) {
        return teacherService.getTeacher(id);
    }

    @PutMapping
    public TeacherEntity update(@RequestBody TeacherEntity student) {
        return teacherService.update(student);
    }

    @GetMapping
    public List<TeacherEntity> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatusCode> delete(@PathVariable(name = "id") Integer id) {
        teacherService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
