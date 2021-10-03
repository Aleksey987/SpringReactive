package com.academiccourseregistration.core.dao.repo;

import com.academiccourseregistration.core.dao.model.Professor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}