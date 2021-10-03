package com.academiccourseregistration.core.api.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProfessorDto {

    private long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private int courseId;
}
