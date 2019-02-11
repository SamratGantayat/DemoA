import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../service/employee.service'
import { Employee } from './employee';

@Component({
  selector: 'app-person',
  templateUrl: './employee.component.html',
  providers : [EmployeeService]
})
export class EmployeeComponent implements OnInit {

  employees : Employee[] ;
  selectedEmployee : Employee;

  constructor(private employeeService : EmployeeService ){
  }

  ngOnInit(): void {
    this.getEmployees();
  }

  public getEmployees() : void{
    this.employeeService.getEmployees().subscribe(
      data=> {this.employees = data},
      error=> {console.log('error occured while fetching persons ');}
    );
  }

  public select(employee:Employee){
    this.selectedEmployee = employee;
  }

}
