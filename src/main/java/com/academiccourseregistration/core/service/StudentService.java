package com.academiccourseregistration.core.service;

import org.springframework.stereotype.Service;

import com.academiccourseregistration.core.api.model.StudentDto;
import com.academiccourseregistration.core.dao.mapper.StudentMapper;
import com.academiccourseregistration.core.dao.model.Student;
import com.academiccourseregistration.core.dao.repo.StudentRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Mono<StudentDto> save(StudentDto student) {
        Student saved = studentRepository.save(StudentMapper.toEntity(student));
        return Mono.just(StudentMapper.toDto(saved));
    }
}
