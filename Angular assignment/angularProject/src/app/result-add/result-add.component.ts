import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { Router, RouterModule, Routes } from '@angular/router';
import { ResultService } from '../result.service';


@Component({
  selector: 'result-add',
  templateUrl: './result-add.component.html',
  styleUrls: ['./result-add.component.css']
})
export class ResultAddComponent {

  addStudent = new FormGroup({
    rollno: new FormControl('', [Validators.required, Validators.pattern('[0-9]*')]),
    name: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z ]*')]),
    dob: new FormControl('', Validators.required),
    score: new FormControl('', [Validators.required, Validators.pattern('[0-9]*')]),

  })

  error = false


  get rollno() { return this.addStudent.get('rollno') }
  get name() { return this.addStudent.get('name') }
  get dob() { return this.addStudent.get('dob') }
  get score() { return this.addStudent.get('score') }

  constructor(private result: ResultService, private routers: Router) { }


  response: any
  add() {

    console.warn(this.addStudent.value)
    this.result.addStudent(this.addStudent.value).subscribe((result) => {
      console.log(result)
      this.response = result

      if (this.response["message"] == "Already exist") {
        this.error = true
        console.warn("Already exist")
      }
      else {
        this.routers.navigate(['/results']);
        console.log("Added Successfully")
      }
    })
  }
}