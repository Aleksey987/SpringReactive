package com.academiccourseregistration.core.service;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import com.academiccourseregistration.core.api.model.CourseDto;

import reactor.core.publisher.Mono;

public interface CourseService {

    Mono<CourseDto> save(@NotNull CourseDto course);

    void registerStudentToCourse(@NotNull long courseId, @NotNull long studentId);

    void assignProfessorToCourse(@NotNull long courseId, @NotNull long professorId);

    void registerStudentToListOfCourses(@NotNull long studentId, @NotNull Collection<Long> courseIds);
}
