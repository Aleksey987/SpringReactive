package com.academiccourseregistration.core.service;

import com.academiccourseregistration.core.api.model.StudentDto;
import com.academiccourseregistration.core.dao.mapper.StudentMapper;
import com.academiccourseregistration.core.dao.model.Student;
import com.academiccourseregistration.core.dao.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Mono<StudentDto> save(StudentDto student) {
        Student saved = studentRepository.save(StudentMapper.toEntity(student));
        return Mono.just(StudentMapper.toDto(saved));
    }
}
