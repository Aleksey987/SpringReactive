package com.academiccourseregistration.core.service;

import com.academiccourseregistration.core.api.model.ProfessorDto;
import com.academiccourseregistration.core.dao.mapper.ProfessorMapper;
import com.academiccourseregistration.core.dao.model.Professor;
import com.academiccourseregistration.core.dao.repo.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository courseRepository;

    public Mono<ProfessorDto> save(ProfessorDto professor) {
        Professor saved = courseRepository.save(ProfessorMapper.toEntity(professor));
        return Mono.just(ProfessorMapper.toDto(saved));
    }
}