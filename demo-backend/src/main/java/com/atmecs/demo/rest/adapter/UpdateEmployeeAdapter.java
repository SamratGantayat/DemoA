package com.atmecs.demo.rest.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateEmployeeAdapter {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String address;
}
