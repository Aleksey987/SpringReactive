package com.academiccourseregistration.core.web;

import com.academiccourseregistration.core.api.model.CourseDto;
import com.academiccourseregistration.core.api.model.ProfessorDto;
import com.academiccourseregistration.core.api.model.StudentDto;
import com.academiccourseregistration.core.service.CourseService;
import com.academiccourseregistration.core.service.ProfessorService;
import com.academiccourseregistration.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class AcademicCourseRegistrationController {

    @Autowired
    private StudentService studentService;
    private ProfessorService professorService;
    private CourseService courseService;

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<StudentDto> addStudent(@RequestBody StudentDto student) {
        return studentService.save(student);
    }

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CourseDto> addCourse(@RequestBody CourseDto course) {
        return courseService.save(course);
    }

    @PostMapping("/professors")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProfessorDto> addProfessor(@RequestBody ProfessorDto professor) {
        return professorService.save(professor);
    }
}