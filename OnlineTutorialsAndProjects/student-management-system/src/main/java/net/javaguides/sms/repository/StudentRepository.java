package net.javaguides.sms.repository;


import net.javaguides.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository
// Because it extends from JpaRepository, there's no need to also say StudentRepository is a Repository
// And, by inheritance, also has the @Transactional annotation
public interface StudentRepository extends JpaRepository<Student, Long> {

}
