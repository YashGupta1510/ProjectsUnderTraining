import { Component, OnInit } from '@angular/core';
import { ResultService } from '../result.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.css']
})
export class ResultsComponent implements OnInit {

  constructor(private result: ResultService, private router: Router) { }

  results: any
  collection: any = [];
  ngOnInit(): void {
    this.result.getAll().subscribe((data) => { this.results = data as object; console.log(data); this.collection = this.results["data"]; });
    console.log(this.results);
  }
  delete(rollno: any) {
    this.result.delete(rollno).subscribe((result) => {
      window.location.reload()
    })
  }
  edit(rollno: any) {
    this.router.navigate(['/edit/' + rollno]);
  }
}
