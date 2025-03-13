package com.example;

import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");
        EntityManager em = emf.createEntityManager();

        // Création des cours
        Course course1 = new Course();
        course1.setTitle("Mathématiques");

        Course course2 = new Course();
        course2.setTitle("Informatique");

        // Création des étudiants
        Student student1 = new Student();
        student1.setName("john fontaine");

        /*Student student2 = new Student();
        student2.setName("John Doe");*/

        // Inscription des étudiants aux cours
        student1.addCourse(course1);
        student1.addCourse(course2);
        //student2.addCourse(course1);

        // Persister les entités
        em.getTransaction().begin();
        em.persist(course1);
        em.persist(course2);
        em.persist(student1);
        //em.persist(student2);
        em.getTransaction().commit();

        // 🔍 Vérification des relations
        Student foundStudent = em.find(Student.class, student1.getId());
        System.out.println("\n=== Cours de " + foundStudent.getName() + " ===");
        for (Course c : foundStudent.getCourses()) {
            System.out.println(" - " + c.getTitle());
        }

        /*Course foundCourse = em.find(Course.class, course1.getId());
        System.out.println("\n=== Étudiants inscrits à " + foundCourse.getTitle() + " ===");
        for (Student s : foundCourse.getStudents()) {
            System.out.println(" - " + s.getName());
        }*/

        em.close();
        emf.close();
    }
}
