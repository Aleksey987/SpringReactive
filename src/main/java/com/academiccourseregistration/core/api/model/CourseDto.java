package com.academiccourseregistration.core.api.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CourseDto {

    private long id;

    @NotNull
    private String name;
}
