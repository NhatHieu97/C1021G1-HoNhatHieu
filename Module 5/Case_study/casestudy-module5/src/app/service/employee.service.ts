import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IEmployee} from '../model/IEmployee';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(
    private http: HttpClient
  ) { }
  private baseURL = 'http://localhost:8080/employees';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  header = { 'content-type': 'application/json'};

  getAll(): Observable<IEmployee[]> {
    return this.http.get<IEmployee[]>(this.baseURL);
  }

  save(employee): Observable<IEmployee> {
    return this.http.post<IEmployee>(this.baseURL , JSON.stringify(employee), {headers: this.header})
  }

  findById(id): Observable<IEmployee> {
    return this.http.get<IEmployee>(this.baseURL + '/' + id).pipe();
  }


  delete(id) {
    return this.http.delete<IEmployee>(this.baseURL + '/' + id).pipe();
  }

  update(id,employee) {
    return this.http.put<IEmployee>(this.baseURL + '/'  + id, employee).pipe();
  }
}
