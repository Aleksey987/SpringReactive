package com.academiccourseregistration.core.dao.repo;

import com.academiccourseregistration.core.dao.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}