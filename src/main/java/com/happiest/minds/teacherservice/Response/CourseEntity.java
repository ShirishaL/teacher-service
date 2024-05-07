package com.happiest.minds.teacherservice.Response;


import lombok.Data;

@Data
public class CourseEntity {
    private Integer Id;
    private Integer courseId;
    private String courseName;
    private String duration;

    public String getteacherFirstName() {
        return null;
    }

    public String getteacherLastName() {
        return null;
    }
}
