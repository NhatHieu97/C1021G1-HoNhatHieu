import { Component, OnInit } from '@angular/core';
import {ICustomer} from "../../../model/ICustomer";
import {CustomerService} from "../../../service/customer.service";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customerId: number = 0;
  customerList: ICustomer[] = [];

  constructor(
    private customerService: CustomerService,
  ) {
  }

  ngOnInit(): void {
  }


}
