import { Component, Input } from '@angular/core';
import { Employee } from '../../employee/employee';
import { EmployeeService} from '../../service/employee.service'

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  providers : [EmployeeService]
})
export class EmployeeDetailsComponent {

  @Input()
  public employee : Employee;

  constructor(private employeeService : EmployeeService ){
  }



}
