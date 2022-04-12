import { Component, OnInit } from '@angular/core';
import {Dictionary} from '../../model/dictionary';
import {WordService} from '../../service/word.service';

@Component({
  selector: 'app-dictionary-list',
  templateUrl: './dictionary-list.component.html',
  styleUrls: ['./dictionary-list.component.css']
})
export class DictionaryListComponent implements OnInit {
  dictionary : Dictionary[];


  constructor(
    private wordService : WordService
  ) {
  }

  ngOnInit(): void {
    this.getAll()
  }

  getAll() {
    this.dictionary = this.wordService.getAll();
  }

}
