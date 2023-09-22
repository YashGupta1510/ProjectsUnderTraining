import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ResultService } from '../result.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-result-edit',
  templateUrl: './result-edit.component.html',
  styleUrls: ['./result-edit.component.css']
})
export class ResultEditComponent implements OnInit {


  editStudent = new FormGroup({
    rollno: new FormControl(),
    name: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z ]*')]),
    dob: new FormControl('', Validators.required),
    score: new FormControl('', [Validators.required, Validators.pattern('[0-9]*')]),
  })

  error = false;
  get rollno() { return this.editStudent.get('rollno') };
  get name() { return this.editStudent.get('name') };
  get dob() { return this.editStudent.get('dob') };
  get score() { return this.editStudent.get('score') };



  constructor(private result: ResultService, private routers: Router, private router: ActivatedRoute) { }

  oldResult: any;
  ngOnInit(): void {

    this.result.getResult(this.router.snapshot.params["rollno"]).subscribe((result) => {
      this.oldResult = result;
      console.log(result);

      this.editStudent.setValue({
        rollno: this.oldResult["data"][0]["rollno"],
        name: this.oldResult["data"][0]["name"],
        dob: this.oldResult["data"][0]["dob"],
        score: this.oldResult["data"][0]["score"]
      })

    });

  }


  response: any
  edit() {
    console.log(this.editStudent.value);
    this.result.editStudent(this.editStudent.value).subscribe((result) => {
      console.log(result)
      this.routers.navigate(['/results']);
      console.log("Edited Successfully")
    }
    );
  }

}
