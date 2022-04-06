import { Component, OnInit } from '@angular/core';
import {ICustomer} from "../../../model/ICustomer";
import {CustomerService} from "../../../service/customer.service";
// import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customerId: number;
  customerList: ICustomer[];
  // public formGroup: FormGroup;

  constructor(
    private customerService: CustomerService,
    // private formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {
      this.customerService.getAll().subscribe(value => {
        this.customerList= value;
      })
        // {
        //   this.formGroup = this.formBuilder.group({
        //     id: '',
        //     name: '',
        //     dateOfBirth: '',
        //     idCard: '',
        //     phoneNumber: '',
        //     email: '',
        //     address: '',
        //     typeCustomer: ''
        //   })
        // }
  }

  getId(id: number) {
    this.customerId = id;
  }


  delete() {
    this.customerService.delete(this.customerId).subscribe(data => {
      this.ngOnInit();
    });
  }

  postEmployeeDetail() {

  }
}
