import { Component} from '@angular/core';
import { EmployeeComponent } from './employee/employee.component'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'

})
export class AppComponent{
  
  title = 'app';

  constructor( ){
  }

}
