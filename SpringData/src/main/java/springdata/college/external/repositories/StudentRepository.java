package springdata.college.external.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdata.college.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
