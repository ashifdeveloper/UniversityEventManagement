package com.geekster.University.Event.Management.service;

import com.geekster.University.Event.Management.model.Department;
import com.geekster.University.Event.Management.model.Student;
import com.geekster.University.Event.Management.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;


    public Iterable<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public String addStudent(Student student) {
        studentRepo.save(student);
        return "Added";
    }

    public Student getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if(optionalStudent.isEmpty()){
            return null;
        }
        return optionalStudent.get();
    }

    public String deleteStudentById(Long id) {
        Optional<Student> myStudentOpt = studentRepo.findById(id);
        Student myStudent = null;
        if(myStudentOpt.isPresent()){
            myStudent=myStudentOpt.get();
        }
        else{
            return "Id Not Found";
        }

        studentRepo.deleteById(id);
        return "Deleted for id "+id;
    }

    public String updateStudentDepartmentById(Long id, Department department) {
        Optional<Student> myStudentOpt = studentRepo.findById(id);
        Student myStudent = null;
        if(myStudentOpt.isPresent()){
            myStudent=myStudentOpt.get();
        }
        else{
            return "Id Not Found";
        }

        myStudent.setDepartment(department);
        studentRepo.save(myStudent);
        return "Updated for id "+id;
    }
}
