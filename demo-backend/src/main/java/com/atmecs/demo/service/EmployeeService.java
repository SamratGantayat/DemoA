package com.atmecs.demo.service;

import com.atmecs.demo.repo.Employee;
import com.atmecs.demo.repo.EmployeeDao;
import com.atmecs.demo.rest.adapter.CreateEmployeeAdapter;
import com.atmecs.demo.rest.adapter.UpdateEmployeeAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private EmployeeFactory employeeFactory;

    public Employee getById(String id) {
        //check for null id

        return employeeDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found with id : " + id));
    }

    public List<Employee> getAll() {
        return employeeDao.findAll();
    }

    public Employee create(CreateEmployeeAdapter createEmployeeAdapter) {

        return employeeDao.save(employeeFactory.buildFromCreateRequest(createEmployeeAdapter));
    }

    public Employee update(String id, UpdateEmployeeAdapter updateEmployeeAdapter) {
        Employee employee = getById(id);

        employeeFactory.buildFromUpdateRequest(employee, updateEmployeeAdapter);

        return employee;
    }

}
