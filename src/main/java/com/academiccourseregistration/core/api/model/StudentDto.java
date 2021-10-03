package com.academiccourseregistration.core.api.model;

import lombok.Data;

@Data
public class StudentDto {
    private long id;
    private String firstName;
    private String lastName;
}