package com.amir.compositeapidemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amir.compositeapidemo.model.Employee;
import com.amir.compositeapidemo.model.EmployeeIdentity;
import com.amir.compositeapidemo.repository.EmployeeRepository;

@SpringBootApplication
public class CompositeApiDemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(CompositeApiDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Cleanup the database
        employeeRepository.deleteAllInBatch();

        // Insert new data
        Employee employee = new Employee(new EmployeeIdentity("E-123", "D-457"),
                "Amir Abdalalh",
                "amir21abdallah@gamil.com",
                "+91-9999999999");

        employeeRepository.save(employee);
    }
}