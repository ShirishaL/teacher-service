package com.happiest.minds.teacherservice.Repository;

import com.happiest.minds.teacherservice.Entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity,Integer> {

    TeacherEntity getTeacherNameByTeacherId(Integer teacherId);
}
