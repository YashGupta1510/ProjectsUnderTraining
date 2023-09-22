import { Injector, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ErrorComponent } from './error/error.component';
import { StudentLoginComponent } from './student-login/student-login.component';
import { ResultPageComponent } from './result-page/result-page.component';
import { ResultsComponent } from './results/results.component';
import { ResultEditComponent } from './result-edit/result-edit.component';
import { ResultAddComponent } from './result-add/result-add.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ErrorComponent,
    StudentLoginComponent,
    ResultPageComponent,
    ResultsComponent,
    ResultEditComponent,
    ResultAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
