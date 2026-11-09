package org.example.studentregistrationmanagement.controller;


import org.example.studentregistrationmanagement.model.Student;
import org.example.studentregistrationmanagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String registerStudent(Student student, Model model) {
        studentService.save(student);
        //model.addAttribute("success", true);
        model.addAttribute("student", new Student());
        return "register";
    }
     @GetMapping("/register")
     public String getForm(Model model){

        model.addAttribute("student", new Student());
        return "register";
     }
    @GetMapping("/all")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "students";
    }


}
