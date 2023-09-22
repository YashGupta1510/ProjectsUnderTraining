import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ErrorComponent } from './error/error.component';
import { StudentLoginComponent } from './student-login/student-login.component';
import { ResultsComponent } from './results/results.component';
import { ResultAddComponent } from './result-add/result-add.component';
import { ResultEditComponent } from './result-edit/result-edit.component';
import { ResultPageComponent } from './result-page/result-page.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'login',
    component: StudentLoginComponent
  },
  {
    path: 'view',
    component: ResultPageComponent
  },
  {
    path: 'results',
    component: ResultsComponent
  },
  {
    path: 'results/add',
    component: ResultAddComponent
  },
  {
    path: 'edit/:rollno',
    component: ResultEditComponent
  },
  {
    path: '**',
    component: ErrorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
