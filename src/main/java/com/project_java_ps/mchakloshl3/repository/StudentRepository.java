package com.project_java_ps.mchakloshl3.repository;

// Importy
import org.springframework.data.jpa.repository.JpaRepository;
import com.project_java_ps.mchakloshl3.model.Student;

import java.util.List;

// Repozytorium JPA dla Studenta
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByEnrolled(boolean enrolled);

    List<Student> findByFirstNameContainingIgnoreCase(String firstName);
}
