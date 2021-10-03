package com.academiccourseregistration.core.service;

import com.academiccourseregistration.core.api.model.CourseDto;
import com.academiccourseregistration.core.dao.mapper.CourseMapper;
import com.academiccourseregistration.core.dao.model.Course;
import com.academiccourseregistration.core.dao.repo.CourseRepository;
import com.academiccourseregistration.core.dao.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    public Mono<CourseDto> save(CourseDto course) {
        Course saved = courseRepository.save(CourseMapper.toEntity(course));
        return Mono.just(CourseMapper.toDto(saved));
    }

    public void registerStudentToCourse(int courseId, int studentId) {
        //studentRepository.f
    }

    public void assignProfessorToCourse(int courseId, int professorId) {

    }
}
