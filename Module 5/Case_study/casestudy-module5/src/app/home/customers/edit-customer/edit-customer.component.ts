import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {CustomerService} from '../../../service/customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ICustomer} from '../../../model/ICustomer';
import {CustomerTypeService} from '../../../service/customer-type.service';
import {ICustomerType} from '../../../model/ICustomerType';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  public formValue: FormGroup;
  private id: number;
  private customer: ICustomer;
  public customerTypeList: ICustomerType[];

  constructor(
    private customerService: CustomerService,
    private customerTypeService: CustomerTypeService,
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private router: Router

  ) {
  }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      id: [''],
      code: [''],
      name: [''],
      dateOfBirth: [''],
      idCard: '',
      phoneNumber: [''],
      email: [''],
      address: [''],
      customerType: ['']
    });
    this.id = this.activatedRoute.snapshot.params.id;
    this.customerService.findById(this.id).subscribe(value => {
      this.customer =value;
      this.formValue.setValue(this.customer);
    }),
      this.customerTypeService.getAll().subscribe(data => {
        this.customerTypeList = data;
      });
  }
  update() {
    console.log(this.formValue.value);
    if (this.formValue.invalid) {
      alert('There was an error!');
    } else {
      this.customerService.update( this.formValue.value.id ,this.formValue.value).subscribe(
        () => {
          this.router.navigateByUrl('customer').then(r => {
            console.log("suscess");});
        }
      );
    }
  }
}
