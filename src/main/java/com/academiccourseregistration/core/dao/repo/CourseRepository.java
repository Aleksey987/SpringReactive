package com.academiccourseregistration.core.dao.repo;

import com.academiccourseregistration.core.dao.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}