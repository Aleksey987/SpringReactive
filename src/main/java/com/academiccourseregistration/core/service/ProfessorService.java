package com.academiccourseregistration.core.service;

import org.springframework.stereotype.Service;

import com.academiccourseregistration.core.api.model.ProfessorDto;
import com.academiccourseregistration.core.dao.mapper.ProfessorMapper;
import com.academiccourseregistration.core.dao.model.Professor;
import com.academiccourseregistration.core.dao.repo.ProfessorRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public Mono<ProfessorDto> save(ProfessorDto professor) {
        Professor saved = professorRepository.save(ProfessorMapper.toEntity(professor));
        return Mono.just(ProfessorMapper.toDto(saved));
    }
}