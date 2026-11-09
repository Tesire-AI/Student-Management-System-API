package org.example.studentregistrationmanagement.Repository;

import org.example.studentregistrationmanagement.model.Student;

import java.util.List;

public interface studentRepository {

    void save(Student student);

    List<Student> findAll();
}
