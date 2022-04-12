import { Injectable } from '@angular/core';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor() { }
  products: Product[] = [{
    id: 1,
    name: 'SamSung',
    price: 2400000,
    description: 'Đẹp'
  }, {
    id: 2,
    name: 'Nokia',
    price: 1560000,
    description: 'Đep'
  }, {
    id: 3,
    name: 'Oppo',
    price: 968000,
    description: 'Sang chảnh'
  }, {
    id: 4,
    name: 'IPhone 8',
    price: 7540000,
    description: 'Gọn nhẹ'
  }];
  getAll() {
    return this.products;
  }
  add(product: Product){
    this.products.unshift(product);
  }
  // @ts-ignore
  getById(id: number): Product{
    // tslint:disable-next-line:prefer-for-of
    for ( let i = 0; i < this.products.length; i++) {
      if ( this.products[i].id === id){
        return this.products[i];
      }
    }
  }

  findById(id: number) {
    return this.products.find(product => product.id === id);
  }

  updateProduct(id: number, product: Product) {
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].id === id) {
        this.products[i] = product;
      }
    }
  }

  deleteProduct(id: number) {
    this.products = this.products.filter(product => {
      return product.id !== id;
    });
  }

}

