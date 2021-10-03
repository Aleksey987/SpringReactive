package com.academiccourseregistration.core.api.model;

import lombok.Data;

@Data
public class ProfessorDto {
    private long id;
    private String firstName;
    private String lastName;
    private int courseId;
}
