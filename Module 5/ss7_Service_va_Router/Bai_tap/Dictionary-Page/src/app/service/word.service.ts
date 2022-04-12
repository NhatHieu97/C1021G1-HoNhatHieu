import { Injectable } from '@angular/core';
import {Dictionary} from '../model/dictionary';

@Injectable({
  providedIn: 'root'
})
export class WordService {
   list: Dictionary[] = [{
    id: 1,
    word: 'hi',
    mean: 'xin chào'
  },
    {
      id: 2,
      word: 'dog',
      mean: 'con chó'
    },
    {
      id: 3,
      word: 'cat',
      mean: 'con mèo'
    },
    {
      id: 4,
      word: 'book',
      mean: 'sách'
    },

  ]

  constructor() { }

  getAll(){
    return this.list
  }


  translate(id : number) {
    for (let a in this.list) {
      if(id === this.list[a].id) {
        return this.list[a].mean

      }
    }
  }
}
