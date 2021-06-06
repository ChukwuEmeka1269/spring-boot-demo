package com.emeka.springbootdemo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());
        if(optionalStudent.isPresent()){
            throw new IllegalStateException("email already exist");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean studentExistById = studentRepository.existsById(id);
        if(!studentExistById){
            throw new IllegalStateException("student with id " + id + " does not exist");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent() {
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalStateException("Student with id " + studentId + " already exist"));
        if(name != null && name.length()> 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && email.length()>0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> optionalStudent = studentRepository.findStudentByEmail(email);
            if(optionalStudent.isPresent()){
                throw new IllegalStateException("email already exist");
            }
            student.setEmail(email);
        }
    }
}
