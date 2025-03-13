package com.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    /*@ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();*/
    @ManyToOne
    @JoinColumn(name = "student_id")  // Clé étrangère dans la table `Course`
    private Student student;
    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Student getStudents() { return student; }
    public void setStudents(Student students) { this.student = students; }

}
