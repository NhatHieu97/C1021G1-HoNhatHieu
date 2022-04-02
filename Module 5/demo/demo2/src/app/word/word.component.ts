import { Component } from '@angular/core';


@Component({
  templateUrl: './word.component.html',
  selector: 'app-word',
  styleUrls: ['./word.component.css']
})


export class WordComponent {
  en: string = 'hello'
  vn: string = 'xin chào'
  imageUrl = 'http://thuthuatphanmem.vn/uploads/2018/09/11/hinh-anh-dep-1_044126531.jpg'
  forgot = false;

  toggleForgot(){
    this.forgot = !this.forgot;
  }
}
