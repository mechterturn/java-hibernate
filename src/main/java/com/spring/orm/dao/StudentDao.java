package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class StudentDao {

    private HibernateTemplate hibernateTemplate;

//    save the student

    @Transactional
    public int insert(Student student) {
//        insert the student
        Integer i = (Integer) this.hibernateTemplate.save(student);
        return i;
    }

//    get the single data

    public Student getStudent(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        return student;
    }

//    get multiple data

    public List<Student> getAllStudents() {
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

//    deleting the data
    @Transactional
    public void deleteStudent(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        this.hibernateTemplate.delete(student);
    }


    //    update the student
    @Transactional
    public void updateStudent(Student student) {
        this.hibernateTemplate.update(student);
        System.out.println("student updated success");
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
