package com.atmecs.demo.service;

import com.atmecs.demo.repo.Employee;
import com.atmecs.demo.rest.adapter.CreateEmployeeAdapter;
import com.atmecs.demo.rest.adapter.UpdateEmployeeAdapter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFactory {

    public Employee buildFromCreateRequest(CreateEmployeeAdapter createEmployeeAdapter) {

        return Employee.builder()
                .firstName(createEmployeeAdapter.getFirstName())
                .lastName(createEmployeeAdapter.getLastName())
                .salary(createEmployeeAdapter.getSalary())
                .address(createEmployeeAdapter.getAddress())
                .build();

    }

    public Employee buildFromUpdateRequest(Employee employee, UpdateEmployeeAdapter updateEmployeeAdapter) {

        employee.setFirstName(updateEmployeeAdapter.getFirstName());
        employee.setLastName(updateEmployeeAdapter.getLastName());
        employee.setSalary(updateEmployeeAdapter.getSalary());
        employee.setAddress(updateEmployeeAdapter.getAddress());
        return employee;
    }

}
