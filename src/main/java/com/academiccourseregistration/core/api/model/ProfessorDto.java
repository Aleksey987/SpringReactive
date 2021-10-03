package com.academiccourseregistration.core.api.model;

import lombok.Data;

@Data
public class ProfessorDto {
    private int id;
    private String firstName;
    private String lastName;
    private int courseId;
}
