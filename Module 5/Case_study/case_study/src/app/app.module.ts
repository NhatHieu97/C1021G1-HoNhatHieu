import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';
import { FooterComponent } from './footer/footer.component';
import { BodyComponent } from './home/body/body.component';
import { HeaderComponent } from './header/header.component';
import { EmployeeComponent } from './home/employee/employee.component';
import { CustomerComponent } from './home/customer/customer.component';


@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    FooterComponent,
    BodyComponent,
    HeaderComponent,
    EmployeeComponent,
    CustomerComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
