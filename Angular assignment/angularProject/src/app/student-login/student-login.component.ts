import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ResultService } from '../result.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-student-login',
  templateUrl: './student-login.component.html',
  styleUrls: ['./student-login.component.css']
})

export class StudentLoginComponent {

  loginForm = new FormGroup({
    rollno: new FormControl('',  [Validators.required, Validators.pattern('[0-9]*')]),
    name: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z ]*')]),
  });

  get rollno() { return this.loginForm.get('rollno'); }
  get name() { return this.loginForm.get('name'); }

  constructor(private result : ResultService, private router : Router) { }

  response : any;
  login() {

    this.result.getStudent(this.loginForm.value).subscribe((result) => {
      console.log(result)
      this.response = result;

      if(this.response["message"] == "valid"){
        sessionStorage.setItem('rollno', this.loginForm.value.rollno!);
        this.router.navigate(['/view'],);
      }else{
        alert("Invalid Credentials");
      }
    });
    

  }

}
