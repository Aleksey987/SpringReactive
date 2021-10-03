package com.academiccourseregistration.core.service;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academiccourseregistration.core.api.model.CourseDto;
import com.academiccourseregistration.core.dao.mapper.CourseMapper;
import com.academiccourseregistration.core.dao.model.Course;
import com.academiccourseregistration.core.dao.model.Professor;
import com.academiccourseregistration.core.dao.model.Student;
import com.academiccourseregistration.core.dao.repo.CourseRepository;
import com.academiccourseregistration.core.dao.repo.ProfessorRepository;
import com.academiccourseregistration.core.dao.repo.StudentRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;

    public Mono<CourseDto> save(CourseDto course) {
        Course saved = courseRepository.save(CourseMapper.toEntity(course));
        return Mono.just(CourseMapper.toDto(saved));
    }

    @Transactional
    public void registerStudentToCourse(long courseId, long studentId) {
        Student student = studentRepository.getById(studentId);
        if (student.getCourses().size() == 3) {
            throw new ServiceException("Student can't has more than 3 course at one time");
        }
        Course course = courseRepository.getById(courseId);
        if (course.getStudents().size() == 50) {
            throw new ServiceException("Course already has 40 students");
        }
        student.getCourses().add(course);
    }

    @Transactional
    public void assignProfessorToCourse(long courseId, long professorId) {
        Professor professor = professorRepository.getById(professorId);
        Course course = courseRepository.getById(courseId);
        course.setProfessor(professor);
    }
}
