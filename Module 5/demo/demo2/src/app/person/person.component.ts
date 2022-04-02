import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {
@Input() name: String | undefined ;
@Input() age: Number | undefined ;
  constructor() { }

  ngOnInit(): void {
  }

}
