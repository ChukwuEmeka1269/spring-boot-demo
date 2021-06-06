package com.emeka.springbootdemo.student;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/student")

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path ="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path ="{studentId}")
    public void editStudentDetails(@PathVariable("studentId") Long studentId,
                                   @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }

}
