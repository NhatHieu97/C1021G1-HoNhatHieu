import { Component, OnInit } from '@angular/core';
import {IStudent} from '../model/IStudent';
import {StudentDao} from '../dao/StudentDao';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  students: IStudent[] = StudentDao.students;
  colorRow = "";

  constructor() { }

  ngOnInit(): void {

  }

}
