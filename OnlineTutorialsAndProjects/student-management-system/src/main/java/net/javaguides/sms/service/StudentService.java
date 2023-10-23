package net.javaguides.sms.service;

import net.javaguides.sms.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getSudentById(Long id);
    Student updateStudent(Student student);

    void deleteStudentById(Long id);
}
