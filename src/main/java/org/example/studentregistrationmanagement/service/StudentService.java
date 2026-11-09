package org.example.studentregistrationmanagement.service;

import org.example.studentregistrationmanagement.Repository.studentRepositoryImpl;
import org.example.studentregistrationmanagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final studentRepositoryImpl studentRepositoryImpl;
    public StudentService( studentRepositoryImpl studentRepositoryImpl){

        this.studentRepositoryImpl= studentRepositoryImpl;
    }
    public void save(Student student) {
        studentRepositoryImpl.save(student);
    }

    public List<Student> findAll() {
        return studentRepositoryImpl.findAll();
    }
}
