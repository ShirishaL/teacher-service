package com.happiest.minds.teacherservice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Teacher")
@Data

public class TeacherEntity
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Id;
    private Integer userId;

    private String teacherFirstName;
    private String teacherLastName;

    public String getTeacherName() {
        return null;
    }

    //private Integer courseId;


}