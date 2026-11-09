package model;

import Repository.studentRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final studentRepositoryImpl studentRepositoryImpl;
    public StudentService( studentRepositoryImpl studentRepositoryImpl){

        this.studentRepositoryImpl= studentRepositoryImpl;
    }
}
