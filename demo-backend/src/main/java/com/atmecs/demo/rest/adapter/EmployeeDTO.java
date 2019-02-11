package com.atmecs.demo.rest.adapter;

import com.atmecs.demo.repo.Employee;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

@JsonPropertyOrder
public class EmployeeDTO {
    private Employee employee;

    public EmployeeDTO(Employee employee) {
        this.employee = employee;
    }

    public String getId(){
        return employee.getId();
    }

    public String getFirstName(){
        return employee.getFirstName();
    }

    public String getLastName(){
        return employee.getLastName();
    }

    public BigDecimal getSalary(){
        return employee.getSalary();
    }

    public String getAddress(){
        return employee.getAddress();
    }


}
