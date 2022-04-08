import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {ICustomer} from '../model/ICustomer';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(
    private http: HttpClient
  ) { }

  private baseURL = 'http://localhost:3000/customer';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getAll(): Observable<ICustomer[]> {
      return this.http.get<ICustomer[]>(this.baseURL);
  }

  save(customer): Observable<ICustomer> {
    return this.http.post<ICustomer>(this.baseURL , customer)
  }

  findById(id): Observable<ICustomer> {
    return this.http.get<ICustomer>(this.baseURL + '/' + id).pipe();
  }


  delete(id) {
    return this.http.delete<ICustomer>(this.baseURL + '/' + id).pipe();
  }

  update(id,customer) {
    return this.http.put<ICustomer>(this.baseURL + '/'  + id, customer).pipe();
  }
}
