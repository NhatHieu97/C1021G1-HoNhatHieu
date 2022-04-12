import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IEmployeePosition} from '../model/IEmployeePosition';

@Injectable({
  providedIn: 'root'
})
export class EmployeePositionService {

  constructor(
    private http: HttpClient
  ) { }
  private baseURL = 'http://localhost:8080/employeePosition';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getAll(): Observable<IEmployeePosition[]> {
    return this.http.get<IEmployeePosition[]>(this.baseURL);
  }

}
