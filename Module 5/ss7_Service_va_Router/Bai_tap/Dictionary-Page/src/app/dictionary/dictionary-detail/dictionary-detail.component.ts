import { Component, OnInit } from '@angular/core';
import {WordService} from '../../service/word.service';
import {ActivatedRoute, ParamMap} from '@angular/router';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  mean : string;
  id:number;

  constructor(
    private service: WordService,
    private activatedRoute:ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((pa:ParamMap)=>{
      this.id = parseFloat(pa.get('id'));
      this.translate(this.id);
      console.log(this.mean);
    })
  }
  translate(id : number) {

    this.mean = this.service.translate(id)
  }

}
