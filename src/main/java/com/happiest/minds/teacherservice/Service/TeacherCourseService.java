package com.happiest.minds.teacherservice.Service;

import com.happiest.minds.teacherservice.Entity.TeacherCourse;
import com.happiest.minds.teacherservice.Entity.TeacherEntity;
import com.happiest.minds.teacherservice.Repository.TeacherCourseRepo;
import com.happiest.minds.teacherservice.Repository.TeacherRepository;
import com.happiest.minds.teacherservice.Response.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherCourseService
{
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherCourseRepo teacherCourseRepo;

    @Autowired
    RestTemplate restTemplate;

    public TeacherCourse create(TeacherCourse teacherCourse){
        return teacherCourseRepo.save(teacherCourse);
    }

    public Map<String,List<String>> getTeachersForCourse(Integer courseId) {
        List<TeacherCourse> teacherCourses = teacherCourseRepo.findAllByCourseId(courseId);
        List<String> teacherList = new ArrayList<>();
        for (TeacherCourse teacherCourse : teacherCourses) {
            TeacherEntity teacherEntity = teacherRepository.getTeacherNameByTeacherId(teacherCourse.getTeacherId());
            teacherList.add(teacherEntity.getTeacherName());
        }
        String fullName = getCourseName(courseId);
        Map<String,List<String>> teacherCourseMap = new HashMap<>();
        teacherCourseMap.put(fullName, teacherList);
        return teacherCourseMap;
    }

    public String getCourseName(Integer courseId) {
        CourseEntity courseEntity = restTemplate.getForObject("http://localhost:8082/student/" + courseId, CourseEntity.class);
        return courseEntity.getteacherFirstName().concat(" ").concat(courseEntity.getteacherLastName());
    }

}
