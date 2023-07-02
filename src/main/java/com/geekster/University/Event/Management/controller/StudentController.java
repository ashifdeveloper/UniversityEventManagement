package com.geekster.University.Event.Management.controller;

import com.geekster.University.Event.Management.model.Department;
import com.geekster.University.Event.Management.model.Student;
import com.geekster.University.Event.Management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("students")
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    //Add a student

    @PostMapping("student")
    public String addStudent(@Valid @RequestBody Student student){
        return studentService.addStudent(student);
    }

    //Get Student By Id
    @GetMapping("student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("students/{id}")
    public String deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }
    //Update Student Department By Id Using Inbuilt crudRepo Method

    @PutMapping("student/{id}/{department}")
    public String updateStudentDepartmentById(@PathVariable Long id,@PathVariable Department department){
        return studentService.updateStudentDepartmentById(id,department);
    }

}
