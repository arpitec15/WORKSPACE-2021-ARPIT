package com.functionalInterfaces;

import com.data.Student;
import com.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static void nameAndActivitiesUsingCondition() {
        List<Student> list = StudentDataBase.getAllStudents();
        Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
        Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;

        list.forEach(student -> {
            if (p1.and(p2).test(student)) {
                System.out.println(student);
            }
        });

    }


    public static void main(String[] args) {

        Predicate<Integer> p = (i) -> i % 2 == 0;
        System.out.println(p.test(2));
        nameAndActivitiesUsingCondition();

    }
}
