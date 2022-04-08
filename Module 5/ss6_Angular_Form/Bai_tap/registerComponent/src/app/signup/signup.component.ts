import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  formValue: FormGroup;
  password: string;


  constructor() { }

  ngOnInit(): void {
    this.formValue = new FormGroup({
      email: new FormControl('', [Validators.email,Validators.required]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      configPassword: new FormControl('', [Validators.required, Validators.minLength(6), Validators.pattern( this.password)]),
      country: new FormControl('', Validators.required),
      age: new FormControl('', Validators.min(18)),
      gender: new FormControl('', Validators.required),
      phone: new FormControl('', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')])
      }
    )
  }

}
