package com.academiccourseregistration.core.dao.mapper;

import com.academiccourseregistration.core.api.model.ProfessorDto;
import com.academiccourseregistration.core.dao.model.Professor;

public class ProfessorMapper {
    public static ProfessorDto toDto(Professor entity) {
        ProfessorDto dto = new ProfessorDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setCourseId(entity.getCourseId());
        return dto;
    }

    public static Professor toEntity(ProfessorDto dto) {
        Professor entity = new Professor();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setCourseId(dto.getCourseId());
        return entity;
    }
}