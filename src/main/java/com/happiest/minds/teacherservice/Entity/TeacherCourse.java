package com.happiest.minds.teacherservice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "teacher_course")
public class TeacherCourse
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer courseId;
    private Integer teacherId;

}
