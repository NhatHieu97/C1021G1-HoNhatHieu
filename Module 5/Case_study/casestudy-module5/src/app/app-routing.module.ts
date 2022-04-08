import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BodyComponent} from './home/body/body.component';
import {EmployeeComponent} from './home/employees/employee/employee.component';
import {CustomerComponent} from './home/customers/customer/customer.component';
import {ListHouseComponent} from './home/service/house/list-house/list-house.component';
import {ListRoomComponent} from './home/service/room/list-room/list-room.component';
import {ListVillaComponent} from './home/service/villa/list-villa/list-villa.component';
import {DetailCustomerComponent} from './home/customers/detail-customer/detail-customer.component';
import {EditCustomerComponent} from './home/customers/edit-customer/edit-customer.component';

const routes: Routes = [
  {
    path:'body', component: BodyComponent
  },
  {
    path:"employee", component: EmployeeComponent
  }
  ,
  {
    path:"customer", component: CustomerComponent
  },
  {
    path:"listHouse", component:ListHouseComponent
  },
  {
    path:"listRoom",component:ListRoomComponent
  },
  {
    path:"listVilla",component:ListVillaComponent
  },
  {
    path:"detail/:id",component:DetailCustomerComponent
  },
  {
    path:"edit/:id",component:EditCustomerComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
