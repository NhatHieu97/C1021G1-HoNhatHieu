import {Component, OnInit} from '@angular/core';
import {ICustomer} from '../../../model/ICustomer';
import {CustomerService} from '../../../service/customer.service';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
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
        code: ['', Validators.compose([Validators.required, Validators.pattern('^(KH-)[0-9]{4}$')])],
        name: ['',Validators.required],
        dateOfBirth: ['',[Validators.required, this.checkAge]],
        idCard: ['',[Validators.required,Validators.pattern('^\\d{9}$')]],
        phoneNumber: ['',[Validators.required, Validators.pattern('((09|03|07|08|05)+([0-9]{8})\\b)')]],
        email: ['',[Validators.required, Validators.pattern('^[a-zA-Z0-9]+[@]([a-zA-Z]{3,7})[.]([a-z]{2,3})$')]],
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

  validation_messages = {
    'code': [
      { type: 'required', message: 'This field is not empty!' },
      { type: 'pattern', message: 'The code is not in the correct format(KH-XXXX)'}
    ],
    'name': [
      { type: 'required', message: 'This field is not empty!' }
    ],
    'dateOfBirth': [
      { type: 'required', message: 'This field is not empty!' }
    ],
    'idCard': [
      { type: 'required', message: 'This field is not empty!' },
      { type: 'pattern', message: 'The id card is not in the correct format(xxxxxxxxx)'}
    ],
    'phoneNumber': [
      { type: 'required', message: 'This field is not empty!' },

      { type: 'pattern', message: 'The id phone number is not in the correct format'}
    ],
    'email': [
      { type: 'required', message: 'This field is not empty!' },
      { type: 'pattern', message: 'The id email is not in the correct format(abc@gmail.com'}
    ],
    'address': [
      { type: 'required', message: 'This field is not empty!' }
    ],

    'typeCustomer': [
      { type: 'required', message: 'This field is not empty!' },
    ],
  }

  checkAge(dateOfBirth : AbstractControl){
    console.log(dateOfBirth)
    const birth = new Date(dateOfBirth.value);
    const birthday = Date.now() - birth.getTime() - 86400000;
    const time = new Date(birthday);
    const age = time.getUTCFullYear() - 1970;
    if(age < 18){
      return {"ageUnder": true};
    }
    return null;
  }

}
