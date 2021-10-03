package com.academiccourseregistration.core.web.controller;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.academiccourseregistration.core.api.model.CourseDto;
import com.academiccourseregistration.core.api.model.ProfessorDto;
import com.academiccourseregistration.core.api.model.StudentDto;
import com.academiccourseregistration.core.service.CourseService;
import com.academiccourseregistration.core.service.ProfessorService;
import com.academiccourseregistration.core.service.StudentService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AcademicCourseRegistrationController {

    public static final String STUDENTS = "/students";
    public static final String COURSES = "/courses";
    public static final String PROFESSORS = "/professors";

    public static final String REGISTER_STUDENT = COURSES + "/{courseId}" + STUDENTS + "/{studentId}";
    public static final String ASSIGN_PROFESSOR = COURSES + "/{courseId}" + PROFESSORS + "/{professorId}";

    private final StudentService studentService;
    private final ProfessorService professorService;
    private final CourseService courseService;

    @PostMapping(PROFESSORS)
    @ResponseStatus(CREATED)
    public Mono<ProfessorDto> addProfessor(@RequestBody ProfessorDto professor) {
        return professorService.save(professor);
    }

    @PostMapping(STUDENTS)
    @ResponseStatus(CREATED)
    public Mono<StudentDto> addStudent(@RequestBody StudentDto student) {
        return studentService.save(student);
    }

    @PostMapping(COURSES)
    @ResponseStatus(CREATED)
    public Mono<CourseDto> addCourse(@RequestBody CourseDto course) {
        return courseService.save(course);
    }

    @PutMapping(REGISTER_STUDENT)
    public void registerStudentToCourse(@PathVariable long courseId,
            @PathVariable long studentId) {
        courseService.registerStudentToCourse(courseId, studentId);
    }

    @PutMapping(ASSIGN_PROFESSOR)
    public void assignProfessorToCourse(@PathVariable long courseId,
            @PathVariable long professorId) {
        courseService.assignProfessorToCourse(courseId, professorId);
    }
}