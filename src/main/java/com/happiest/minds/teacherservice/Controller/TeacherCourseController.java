package com.happiest.minds.teacherservice.Controller;

import com.happiest.minds.teacherservice.Entity.TeacherCourse;
import com.happiest.minds.teacherservice.Service.TeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teachercourse")
public class TeacherCourseController
{
    @Autowired
    TeacherCourseService teacherCourseService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping
    public TeacherCourse create(@RequestBody TeacherCourse teacherCourse){
        return teacherCourseService.create(teacherCourse);
    }

    @GetMapping("/{studentId}")
    public Map<String, List<String>> getTeachersForCourse(@PathVariable Integer courseId) {
        return teacherCourseService.getTeachersForCourse(courseId);
    }
/*
    @GetMapping("/{courseId}")
    public Map<String,List<String>> getStudentsForCourse(@PathVariable Integer courseId) {
        return teacherCourseService.getStudentsForCourse(courseId);
    }*/

}
