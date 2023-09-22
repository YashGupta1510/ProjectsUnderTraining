import { Component } from '@angular/core';
import { ResultService } from '../result.service';

@Component({
  selector: 'app-result-page',
  templateUrl: './result-page.component.html',
  styleUrls: ['./result-page.component.css']
})
export class ResultPageComponent {


  constructor(private result: ResultService,) { }

  name: any;
  rollno: any;
  score: any;
  dob: any;

  response: any;

  ngOnInit(): void {
    this.rollno = sessionStorage.getItem('rollno');
    console.log(this.rollno);
    this.result.getResult(this.rollno).subscribe((data) => {
      this.response = data;
      this.name = this.response["data"][0]["name"];
      this.score = this.response["data"][0]["score"];
      this.dob = this.response["data"][0]["dob"];
    });
  }
}
