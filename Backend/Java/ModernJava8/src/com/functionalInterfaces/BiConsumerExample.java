package com.functionalInterfaces;

import com.data.Student;
import com.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void namesAndActivites() {
        List<Student> list = StudentDataBase.getAllStudents();
        BiConsumer<String, List<String>> biConsumer = (name, activities) -> {
            System.out.println(name + " : " + activities);
        };

        list.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
    }

    public static void main(String[] args) {

        BiConsumer<String, String> biConsumer = (a, b) -> {
            System.out.println("a : " + a + ",b : " + b);
        };
        biConsumer.accept("java7", "java8");

        BiConsumer<Integer, Integer> multiply = (a, b) -> {
            int c = a * b;
            System.out.println("Product is " + c);
        };
        multiply.accept(2, 3);

        namesAndActivites();


    }
}

