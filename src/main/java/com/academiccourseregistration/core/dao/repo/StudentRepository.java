package com.academiccourseregistration.core.dao.repo;

import com.academiccourseregistration.core.dao.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}