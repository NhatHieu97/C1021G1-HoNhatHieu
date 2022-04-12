import { Component, OnInit } from '@angular/core';
import {IEmployee} from '../../../model/IEmployee';
import {EmployeeService} from '../../../service/employee.service';
import {EmployeePositionService} from '../../../service/employee-position.service';
import {EmployeeEducationDegreeService} from '../../../service/employee-education-degree.service';
import {ActivatedRoute, Router} from '@angular/router';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {IEmployeePosition} from '../../../model/IEmployeePosition';
import {IEmployeeEducationDegree} from '../../../model/IEmployeeEducationDegree';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  employeeId: number;
  employeeList:IEmployee[];
  public formValue: FormGroup;
  public employeePositionList: IEmployeePosition[];
  public employeeEducationDegreeList: IEmployeeEducationDegree[];
  private id: number;
  public employee: IEmployee = {};


  constructor(
    private employeeService: EmployeeService,
    private employeePosition: EmployeePositionService,
    private employeeEducationDegree: EmployeeEducationDegreeService,
    private activatedRoute: ActivatedRoute,
    private formBuilder: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      id: [''],
      name: ['',Validators.required],
      gender: [''],
      birthday: ['',[Validators.required, this.checkAge]],
      idCard: ['',[Validators.required,Validators.pattern('^\\d{9}$')]],
      phone: ['',[Validators.required, Validators.pattern('((09|03|07|08|05)+([0-9]{8})\\b)')]],
      email: ['',[Validators.required, Validators.pattern('^[a-zA-Z0-9]+[@]([a-zA-Z]{3,7})[.]([a-z]{2,3})$')]],
      address: ['',Validators.required],
      salary: ['',Validators.required],
      employeePosition: ['',Validators.required],
      employeeEducationDegree: ['',Validators.required],
    });
    this.employeeService.getAll().subscribe((data: IEmployee[])=>{
      this.employeeList = data
    }),
      this.employeePosition.getAll().subscribe((data: IEmployeePosition[])=>{
        this.employeePositionList = data
      }),
      this.employeeEducationDegree.getAll().subscribe((data: IEmployeeEducationDegree[])=>{
        this.employeeEducationDegreeList = data
      })
  }
  getId(id: number) {
    this.employeeId = id;
  }

  delete() {
    this.employeeService.delete(this.employeeId).subscribe(data => {
      this.ngOnInit();
    });
  }


  saveEmployee() {

    if (this.formValue.invalid) {
      alert('There was an error!');
    } else {
      this.employee.name = this.formValue.get("name").value
      this.employee.birthday = this.formValue.get("birthday").value
      this.employee.idCard = this.formValue.get("idCard").value
      this.employee.phone = this.formValue.get("phone").value
      this.employee.email = this.formValue.get("email").value
      this.employee.address = this.formValue.get("address").value
      this.employee.salary =Number(this.formValue.get("salary").value)
      for (let i = 0; i < this.employeePositionList.length; i++){
        if(this.formValue.get("employeePosition").value == this.employeePositionList[i].id){
          this.employee.employeePosition = this.employeePositionList[i]
        }
      }
      for (let i = 0; i < this.employeeEducationDegreeList.length; i++){
        if(this.formValue.get("employeeEducationDegree").value == this.employeeEducationDegreeList[i].id){
          this.employee.employeeEducationDegree = this.employeeEducationDegreeList[i]
        }
      }

      this.formValue.get('gender').setValue(this.employee.gender ? 'Man' : (!this.employee.gender ? 'Woman' : 'Other' ));

      this.employee.gender = this.formValue.get('gender').value === 'Man' ? true :
        (!(this.formValue.get('gender').value === 'Woman') ? null : false)


      console.log(this.employee);
      this.employeeService.save(this.employee).subscribe(
        () => {
          this.ngOnInit();

        }
      );
      let ref = document.getElementById('cancel');
      ref?.click();


    }
  }
  validation_messages = {
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
    'salary': [
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
