package com.functionalInterfaces;

import com.data.Student;
import com.data.StudentDataBase;

import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class ConsumerExample {
    static Consumer<Student> c2 = (student) -> System.out.println(student);
    static Consumer<Student> c3 = (student) -> System.out.println(student.getName());
    static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());

    public static void printNames() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c2);
    }

    public static void printNamesAndActivites() {
        List<Student> studentNameList = StudentDataBase.getAllStudents();
//        consumer chain
        studentNameList.forEach(c3.andThen(c4));
    }

    public static void printNameAndActivitesUsingConditoin() {
        List<Student> studentList = StudentDataBase.getAllStudents();
//        We can achieve code reusability with lambda by using reusing conditions
        studentList.forEach(student -> {
            if(student.getGradeLevel() >= 3 && student.getGpa() >= 3.9){
                c3.andThen(c4).accept(student);
            }
        });
    }

    public static void main(String[] args) {
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
        c1.accept("arpit");
//        printNames();
//        printNamesAndActivites();
        printNameAndActivitesUsingConditoin();
    }

}
