package wsy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wsy.model.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {
    public Course findByName(String name);
}
