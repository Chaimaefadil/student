package com.example;

import com.example.Student;
import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@OneToOne(mappedBy = "address")
private Student student;
    private String street;
    private String city;
    public Address(){};
    public Address(String street,String city,Student student){
        this.street=street;
        this.city=city;
        this.student=student;

    }
    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public Student getStudent(){
        return student;
    }
    public void setStudent(Student student){
        this.student=student;
    }

}
