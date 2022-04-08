import {Component, OnInit} from '@angular/core';
import {ICustomer} from '../../../model/ICustomer';
import {CustomerService} from '../../../service/customer.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ICustomerType} from '../../../model/ICustomerType';
import {CustomerTypeService} from '../../../service/customer-type.service';

// import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customerId: number;
  customerList: ICustomer[];
  public customerTypeList: ICustomerType[];
  formValue: FormGroup;

  // public formGroup: FormGroup;

  constructor(
    private customerService: CustomerService,
    private customerTypeService: CustomerTypeService,
    private formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.customerService.getAll().subscribe(value => {
      this.customerList = value;
    }),
      this.customerTypeService.getAll().subscribe(data => {
        this.customerTypeList = data;
      });
    {
      this.formValue = this.formBuilder.group({
        id: [''],
        code: ['',Validators.required],
        name: ['',Validators.required],
        dateOfBirth: ['',Validators.required],
        idCard: ['',Validators.required],
        phoneNumber: ['',Validators.required],
        email: ['',Validators.required],
        address: ['',Validators.required],
        customerType: ['',Validators.required]
      });
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
      alert('There was an error!');
    } else {
      this.customerService.save(this.formValue.value).subscribe(
        () => {
          this.ngOnInit();
        }
      );
      let ref = document.getElementById('cancel');
      ref?.click();


    }
  }

}
