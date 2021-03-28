package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class ExampleClient2 {

    @Autowired
    private EmployeeRepository repo;

    public void run(ApplicationContext context) {
        Employee employee = Employee.create("Diana", "Admin", 3000);
        repo.save(employee);
        Long employeeId = employee.getId();
        System.out.println("-- employee persisted --");
        System.out.println(findEmployee(employeeId));

        ExecutorService es = Executors.newFixedThreadPool(2);

        //user 1
        es.execute(() -> {
            System.out.println(" -- user1 updating salary to 2000 --");
            Employee employee2 = findEmployee(employeeId);
            System.out.println("user1 loaded entity: " + employee2);
            employee2.setSalary(2000);
            //little delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                repo.save(employee2);
            } catch (Exception e) {
                System.err.println("user1 " + e);
                System.out.println("user1 after error: " + findEmployee(employeeId));
                return;
            }
            System.out.println("user1 finished: " + findEmployee(employeeId));
        });

        //user 2
        es.execute(() -> {
            System.out.println(" -- user2 updating salary to 4000 --");
            Employee employee3 = findEmployee(employeeId);
            System.out.println("user2 loaded entity: " + employee3);
            employee3.setSalary(4000);
            try {
                repo.save(employee3);
            } catch (Exception e) {
                System.err.println("user2: " + e);
                System.out.println("user2 after error: " + findEmployee(employeeId));
                return;
            }
            System.out.println("user2 finished: " + findEmployee(employeeId));
        });

        es.shutdown();
        try {
            es.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
    }

    private Employee findEmployee(long employeeId) {
        Optional<Employee> opt = repo.findById(employeeId);
        return opt.isPresent() ? opt.get() : null;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        ExampleClient2 exampleClient = context.getBean(ExampleClient2.class);
        exampleClient.run(context);

    }
}