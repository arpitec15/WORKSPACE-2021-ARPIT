package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

@Component
public class ExampleClient {

    @Autowired
    private EmployeeRepository repo;

    public void run() {
        Employee employee = Employee.create("Diana", "Admin", 3000);
        repo.save(employee);
        Long employeeId = employee.getId();
        System.out.println("-- employee persisted --");
        System.out.println(findEmployee(employeeId));

        System.out.println(" -- updating salary to 2000 --");
        Employee employee2 = findEmployee(employeeId);
        employee2.setSalary(2000);
        repo.save(employee2);
        System.out.println(findEmployee(employeeId));

        System.out.println(" -- updating salary to 4000 --");
        Employee employee3 = findEmployee(employeeId);
        employee3.setSalary(4000);
        repo.save(employee3);
        System.out.println(findEmployee(employeeId));
    }

    private Employee findEmployee(long employeeId) {
        Optional<Employee> opt = repo.findById(employeeId);
        return opt.isPresent()? opt.get(): null;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        ExampleClient exampleClient = context.getBean(ExampleClient.class);
        exampleClient.run();
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
    }
}