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
import {FormsModule} from '@angular/forms';


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


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
