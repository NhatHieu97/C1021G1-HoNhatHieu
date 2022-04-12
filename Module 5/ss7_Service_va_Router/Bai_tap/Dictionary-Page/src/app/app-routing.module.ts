import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictionaryListComponent} from './dictionary/dictionary-list/dictionary-list.component';
import {DictionaryDetailComponent} from './dictionary/dictionary-detail/dictionary-detail.component';


const routes: Routes = [
  {
    path:"" , component: DictionaryListComponent

  },
  {
    path:"information/:id", component: DictionaryDetailComponent
  }





];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
