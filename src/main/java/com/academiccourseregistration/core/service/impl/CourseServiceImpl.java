package com.academiccourseregistration.core.service.impl;

import static java.lang.String.format;

import static com.academiccourseregistration.core.util.Constants.COURSE_MAX_STUDENTS;
import static com.academiccourseregistration.core.util.Constants.STUDENT_MAX_COURSES;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.academiccourseregistration.core.api.model.CourseDto;
import com.academiccourseregistration.core.dao.mapper.CourseMapper;
import com.academiccourseregistration.core.dao.model.Course;
import com.academiccourseregistration.core.dao.model.Professor;
import com.academiccourseregistration.core.dao.model.Student;
import com.academiccourseregistration.core.dao.repo.CourseRepository;
import com.academiccourseregistration.core.dao.repo.ProfessorRepository;
import com.academiccourseregistration.core.dao.repo.StudentRepository;
import com.academiccourseregistration.core.service.CourseService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@Validated
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;

    @Override
    public Mono<CourseDto> save(@NotNull CourseDto course) {
        Course saved = courseRepository.save(CourseMapper.toEntity(course));
        return Mono.just(CourseMapper.toDto(saved));
    }

    @Override
    @Transactional
    public void registerStudentToCourse(@NotNull long courseId, @NotNull long studentId) {
        Student student = studentRepository.getById(studentId);
        if (student.getCourses().size() == STUDENT_MAX_COURSES) {
            throw new ServiceException(format("Student can't has more than %s course at one time", STUDENT_MAX_COURSES));
        }
        Course course = courseRepository.getById(courseId);
        if (course.getStudents().size() == COURSE_MAX_STUDENTS) {
            throw new ServiceException(format("Course already has %s students", COURSE_MAX_STUDENTS));
        }
        student.getCourses().add(course);
    }

    @Override
    @Transactional
    public void assignProfessorToCourse(@NotNull long courseId, @NotNull long professorId) {
        Professor professor = professorRepository.getById(professorId);
        Course course = courseRepository.getById(courseId);
        course.setProfessor(professor);
    }

    @Override
    @Transactional
    public void registerStudentToListOfCourses(@NotNull long studentId, @NotNull Collection<Long> courseIds) {
        Student student = studentRepository.getById(studentId);
        Collection<Course> courses = courseRepository.findAllById(courseIds);
        if (student.getCourses().size() + courses.size() > STUDENT_MAX_COURSES) {
            throw new ServiceException(format("Student can't has more than %s course at one time", STUDENT_MAX_COURSES));
        }
        student.getCourses().addAll(courses);
    }

}