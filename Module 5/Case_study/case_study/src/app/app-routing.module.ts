import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FormComponent} from "./form/form.component";
import {BodyComponent} from "./home/body/body.component";
import {EmployeeComponent} from "./home/employee/employee.component";
import {CustomerComponent} from "./home/customer/customer.component";

const routes: Routes = [
  {
    path:"body",component:BodyComponent
  },
  {
    path:"employee",component:EmployeeComponent
  }
  ,
  {
    path:"customer",component:CustomerComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
