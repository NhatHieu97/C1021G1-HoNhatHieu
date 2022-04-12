import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IEmployeePosition} from '../model/IEmployeePosition';
import {IEmployeeEducationDegree} from '../model/IEmployeeEducationDegree';

@Injectable({
  providedIn: 'root'
})
export class EmployeeEducationDegreeService {

  constructor(
    private http: HttpClient
  ) { }

  private baseURL = 'http://localhost:8080/employeeEducationDegree';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getAll(): Observable<IEmployeeEducationDegree[]> {
    return this.http.get<IEmployeeEducationDegree[]>(this.baseURL);
  }
}
