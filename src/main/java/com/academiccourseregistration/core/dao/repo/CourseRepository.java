package com.academiccourseregistration.core.dao.repo;

import com.academiccourseregistration.core.dao.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}