package com.happiest.minds.teacherservice.Repository;

import com.happiest.minds.teacherservice.Entity.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherCourseRepo extends JpaRepository<TeacherCourse, Integer> {

    static List<TeacherCourse> findAllByTeacherId(Integer teacherId) {
        return null;
    }

    List<TeacherCourse> findAllByCourseId(Integer courseId);
}