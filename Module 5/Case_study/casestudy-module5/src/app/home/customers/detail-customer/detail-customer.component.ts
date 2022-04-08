import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ICustomerType} from '../../../model/ICustomerType';
import {ICustomer} from '../../../model/ICustomer';
import {CustomerService} from '../../../service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-detail-customer',
  templateUrl: './detail-customer.component.html',
  styleUrls: ['./detail-customer.component.css']
})
export class DetailCustomerComponent implements OnInit {
  id:number;
  public formGroup: FormGroup;
  public customerTypeList: ICustomerType[];
  public customer: ICustomer;
  constructor(
    private customerService: CustomerService,
    private activatedRoute: ActivatedRoute,
    private formBuilder: FormBuilder,
    private router: Router

  ) { }

  ngOnInit(): void {

    this.formGroup = this.formBuilder.group({
      id: '',
      code: '',
      name: '',
      dateOfBirth: '',
      idCard: '',
      phoneNumber:'',
      email: '',
      address: '',
      customerType : ''
    });

      this.id = this.activatedRoute.snapshot.params.id;
       this.customerService.findById(this.id).subscribe(value => {

         this.customer =value;
         this.formGroup.setValue(this.customer);
      })
  }

}
