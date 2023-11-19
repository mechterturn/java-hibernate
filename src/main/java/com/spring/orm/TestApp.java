package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class TestApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = new ClassPathXmlApplicationContext("hibernateconfig.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean value = true;

        while (value) {
            System.out.println(" Press 1 for add new student ");
            System.out.println(" Press 2 for get single student ");
            System.out.println(" Press 3 for display all the students ");
            System.out.println(" Press 4 for update the student ");
            System.out.println(" Press 5 for delete the student ");
            System.out.println(" Press 6 for exit of the program ");

            try {
                int input = Integer.parseInt(br.readLine());

                switch (input) {
                    case 1:
//                        add the new student
                        System.out.println("Enter the student details ");

                        System.out.print("Enter The Student Id: ");
                        int studentId = scanner.nextInt();

                        // Consume the newline character
                        scanner.nextLine();

                        System.out.print("Enter The Student Name: ");
                        String studentName = scanner.nextLine();


                        System.out.print("Enter The Student City: ");
                        String studentCity = scanner.nextLine();

                        Student student = new Student(studentId, studentName, studentCity);
                        int r = studentDao.insert(student);
                        System.out.println("Student data inserted succesfully " + r);
                        break;

                    case 2:
//                        get the single student
                        System.out.println("Enter the student Id ");

                        System.out.print("Enter The Student Id: ");
                        int studentSingleId = scanner.nextInt();
                        Student student1 = studentDao.getStudent(studentSingleId);
                        System.out.println("Student Id : " + student1.getStudentId());
                        System.out.println("Student Name : " + student1.getStudentName());
                        System.out.println("Student City : " + student1.getStudentCity());

                        break;

                    case 3:
//                        get the all students
                        System.out.println("All students data ");
                        List<Student> studentList = studentDao.getAllStudents();
                        for (Student  s : studentList) {
                            System.out.println("Student Id: " + s.getStudentId()
                                  +  "   Student Name: " + s.getStudentName()
                                  +  "   Student City: " + s.getStudentCity()
                            );
                        }

                        break;

                    case 4:
//                        update the student
                        System.out.println("Update the student");
                        System.out.print("Enter The Student Id: ");
                        int studentUpdateId = scanner.nextInt();
                        Student student2 = studentDao.getStudent(studentUpdateId);

                        // Consume the newline character
                        scanner.nextLine();
                        System.out.print("Enter The Student Name: ");
                        String studenUpdatetName = scanner.nextLine();
                        student2.setStudentName(studenUpdatetName);

                        System.out.print("Enter The Student Name: ");
                        String studenUpdatetCity = scanner.nextLine();
                        student2.setStudentCity(studenUpdatetCity);

                        studentDao.updateStudent(student2);

                        break;

                    case 5:
//                        delete the student
                        System.out.println("Delete the student ");
                        System.out.print("Enter The Student Id: ");
                        int studentDeleteId = scanner.nextInt();
                        studentDao.deleteStudent(studentDeleteId);
                        System.out.println("student deleted successfully");

                        break;

                    case 6:
//                        exit the student
                        value = false;
                        System.out.println("Program exit successfully");
                        break;

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }
}
