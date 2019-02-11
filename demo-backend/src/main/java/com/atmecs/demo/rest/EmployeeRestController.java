package com.atmecs.demo.rest;

import com.atmecs.demo.rest.adapter.CreateEmployeeAdapter;
import com.atmecs.demo.rest.adapter.EmployeeDTO;
import com.atmecs.demo.rest.adapter.UpdateEmployeeAdapter;
import com.atmecs.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/v1/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/{id}")
    public EmployeeDTO getById(@PathVariable("id") String id){
        System.out.println("Id is : "+id);

        return new EmployeeDTO(employeeService.getById(id));
    }

    @GetMapping
    public List<EmployeeDTO> getAll(){
        return employeeService.getAll().stream().map(EmployeeDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public EmployeeDTO create(@RequestBody CreateEmployeeAdapter createEmployeeAdapter){

        return new EmployeeDTO(employeeService.create(createEmployeeAdapter));
    }

    @PutMapping(path = "/{id}")
    public EmployeeDTO update(@PathVariable("id") String id, @RequestBody UpdateEmployeeAdapter updateEmployeeAdapter){

        return new EmployeeDTO(employeeService.update(id,updateEmployeeAdapter));
    }

}
