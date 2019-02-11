import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../employee/employee';

const httpOptions = {
  headers: new HttpHeaders({ 'Access-Control-Allow-Origin' : '*' })
};

@Injectable()
export class EmployeeService{
  private API = 'http://localhost:8080/v1/employees';
  

  constructor(private http : HttpClient) { } 

  public getEmployees(): Observable<Employee[]>{
    let url = this.API;
    return this.http.get<Employee[]>(url,httpOptions);
  }

}
