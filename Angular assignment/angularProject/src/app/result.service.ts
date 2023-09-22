import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
    providedIn: 'root'
})

export class ResultService {

    api = "http://localhost:3000/"


    constructor(private http: HttpClient) { }
    getAll() {
        return this.http.get(this.api + "viewall");

    }

    getResult(rollno: any) {
        return this.http.get(this.api + "viewresult/" + rollno);

    }

    getStudent(data: any) {
        return this.http.post(this.api + "login", data);
    }

    addStudent(data: any) {
        return this.http.post(this.api + "add", data);
    }

    editStudent(data: any) {
        return this.http.post(this.api + "edit", data);

    }

    delete(rollno: any) {
        return this.http.get(this.api + "delete/" + rollno);

    }
}