import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';
import { FooterComponent } from './footer/footer.component';
import { BodyComponent } from './home/body/body.component';
import { HeaderComponent } from './header/header.component';
import { EmployeeComponent } from './home/employees/employee/employee.component';
import { CustomerComponent } from './home/customers/customer/customer.component';
import { ListHouseComponent } from './home/service/house/list-house/list-house.component';
import { ListRoomComponent } from './home/service/room/list-room/list-room.component';
import { ListVillaComponent } from './home/service/villa/list-villa/list-villa.component';
import { CreateCustomerComponent } from './home/customers/create-customer/create-customer.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { DeleteCustomerComponent } from './home/customers/delete-customer/delete-customer.component';
import { DetailCustomerComponent } from './home/customers/detail-customer/detail-customer.component';
import { EditCustomerComponent } from './home/customers/edit-customer/edit-customer.component';
import { DetailEmployeeComponent } from './home/employees/detail-employee/detail-employee.component';
import { CreateEmployeeComponent } from './home/employees/create-employee/create-employee.component';
import { EditEmployeeComponent } from './home/employees/edit-employee/edit-employee.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';



@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    FooterComponent,
    BodyComponent,
    HeaderComponent,
    EmployeeComponent,
    CustomerComponent,
    ListHouseComponent,
    ListRoomComponent,
    ListVillaComponent,
    CreateCustomerComponent,
    DeleteCustomerComponent,
    DetailCustomerComponent,
    EditCustomerComponent,
    DetailEmployeeComponent,
    CreateEmployeeComponent,
    EditEmployeeComponent,

  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule,
        BrowserModule,
        NgxPaginationModule,
        MatSnackBarModule,
        BrowserAnimationsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
