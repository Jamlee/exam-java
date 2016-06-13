package wsy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import wsy.model.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
}
