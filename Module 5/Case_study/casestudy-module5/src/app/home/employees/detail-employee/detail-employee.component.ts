import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {IEmployeePosition} from '../../../model/IEmployeePosition';
import {IEmployee} from '../../../model/IEmployee';
import {IEmployeeEducationDegree} from '../../../model/IEmployeeEducationDegree';
import {EmployeeService} from '../../../service/employee.service';
import {EmployeePositionService} from '../../../service/employee-position.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {EmployeeEducationDegreeService} from '../../../service/employee-education-degree.service';

@Component({
  selector: 'app-detail-employee',
  templateUrl: './detail-employee.component.html',
  styleUrls: ['./detail-employee.component.css']
})
export class DetailEmployeeComponent implements OnInit {
  public formValue: FormGroup;
  public employeePositionList: IEmployeePosition[];
  public employeeEducationDegreeList: IEmployeeEducationDegree[];
  public employee: IEmployee;
  private id: number;

  constructor(
    private employeeService: EmployeeService,
    private employeePosition: EmployeePositionService,
    private employeeEducationDegree: EmployeeEducationDegreeService,
    private activatedRoute: ActivatedRoute,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.employeePosition.getAll().toPromise().then(data =>{
      this.employeePositionList = data;
    },
      );
    this.employeeEducationDegree.getAll().toPromise().then(data =>{
        this.employeeEducationDegreeList = data;
      },
    );
  }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      id: '',
      name: '',
      gender: '',
      birthday: '',
      idCard: '',
      phone: '',
      email: '',
      address: '',
      salary: '',
      employeePosition: '',
      employeeEducationDegree: ''
    });

    this.id = this.activatedRoute.snapshot.params.id;
    this.employeeService.findById(this.id).subscribe(value => {

      this.employee =value;
      this.formValue.setValue(this.employee);
      this.formValue.get('employeePosition').setValue(this.employee.employeePosition.name);
      this.formValue.get('employeeEducationDegree').setValue(this.employee.employeeEducationDegree.name);
      this.formValue.get('gender').setValue(this.employee.gender ? 'Man' : (this.employee.gender != null ? 'Woman' : 'Other' ));
    })
  }

}
