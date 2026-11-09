package org.example.studentregistrationmanagement.Repository;

import org.example.studentregistrationmanagement.model.Student;
import org.example.studentregistrationmanagement.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class studentRepositoryImpl implements studentRepository {
     private final DatabaseConnection db;

    public studentRepositoryImpl(DatabaseConnection db) {
        this.db = db;
    }

    @Override
     public void save(Student student) {

     }

     @Override
     public List<Student> findAll() {
          return new ArrayList<>();
     }
}
