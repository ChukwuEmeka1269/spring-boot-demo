package com.emeka.springbootdemo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;

    @Transient
    private Integer age;
    private String email;
    private LocalDate dateOfBirth;

    public Integer getAge(){
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public Integer setAge(Integer age){
        return this.age = age;

    }


        public Student(String name,
                   String email,
                   LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }



}
