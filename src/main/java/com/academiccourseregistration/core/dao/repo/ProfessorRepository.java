package com.academiccourseregistration.core.dao.repo;

import com.academiccourseregistration.core.dao.model.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
}