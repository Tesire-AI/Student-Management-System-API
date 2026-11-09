package model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){

        this.studentService= studentService;
    }
    @PostMapping("/register")
     public void displayForm(){


     }
     @GetMapping("/register")
     public void getForm(){

     }
     @PostMapping("/all")
     public List<Student> getAllStudents(){

     }


}
