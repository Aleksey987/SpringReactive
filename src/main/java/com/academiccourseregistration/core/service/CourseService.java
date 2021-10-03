package com.academiccourseregistration.core.service;

import com.academiccourseregistration.core.api.model.CourseDto;
import com.academiccourseregistration.core.dao.mapper.CourseMapper;
import com.academiccourseregistration.core.dao.model.Course;
import com.academiccourseregistration.core.dao.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Mono<CourseDto> save(CourseDto course) {
        Course saved = courseRepository.save(CourseMapper.toEntity(course));
        return Mono.just(CourseMapper.toDto(saved));
    }
}
