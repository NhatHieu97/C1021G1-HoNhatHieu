import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  name: '' | undefined ;
  currentStyle="{color: 'red', fontSize: '30px'}"
  isHighlight = true;

  constructor() { }

  ngOnInit(): void {
  }

  showEvent(event: any){
    // @ts-ignore
    this.name(event);
  }



}
