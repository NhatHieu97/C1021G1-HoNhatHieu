import { Component, OnInit } from '@angular/core';
import {ICustomer} from "../../../model/ICustomer";
import {CustomerService} from "../../../service/customer.service";
import {FormBuilder, FormGroup} from '@angular/forms';
// import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customerId: number;
  customerList: ICustomer[];
  formValue: FormGroup;

  // public formGroup: FormGroup;

  constructor(
    private customerService: CustomerService,
    private formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.customerService.getAll().subscribe(value => {
      this.customerList = value;
    })
    {
      this.formValue = this.formBuilder.group({
        id: [''],
        name: [''],
        dateOfBirth: [''],
        idCard: '',
        phoneNumber: [''],
        email: [''],
        address: [''],
        customerType: ['']
      })
    }
  }

  getId(id: number) {
    this.customerId = id;
  }


  delete() {
    this.customerService.delete(this.customerId).subscribe(data => {
      this.ngOnInit();
    });
  }

  saveCustomer() {
    if (this.formValue.invalid) {
      alert('There was an error!')
    } else {
      this.customerService.save(this.formValue.value).subscribe(data => {
        this.ngOnInit();
      })
    }
  }
}
