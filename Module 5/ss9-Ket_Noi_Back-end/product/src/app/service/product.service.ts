import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseURL = 'http://localhost:3000/products';

  constructor(private http: HttpClient) {
  }

  getAll():Observable<Product[]> {
    return this.http.get<Product[]>(this.baseURL)
  }

  addProduct(product):Observable<Product> {
    return this.http.post<Product>(this.baseURL,product)
  }

  findById(id: number):Observable<Product> {
    return this.http.get<Product>(this.baseURL + '/' + id)
  }

  updateProduct(id: number, product: Product):Observable<Product> {
    return this.http.put<Product>(this.baseURL + '/' + id,product)
  }

  deleteProduct(id: number) {
    return this.http.delete(this.baseURL + '/' + id)
  }
}
