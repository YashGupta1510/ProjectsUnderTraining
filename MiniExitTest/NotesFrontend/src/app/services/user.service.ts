
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { API } from "../constants";


@Injectable({
    providedIn: 'root'
})

export class UserService {


    api = API + "users";


    constructor(private http: HttpClient) { }

    verifyUser(credentials: any) {
        return this.http.post(this.api + "/verify", credentials);
    }

    registerUser(user: any) {
        return this.http.post(this.api + "/create", user);
    }

    getUser(id: any) {
        return this.http.get(this.api + "/" + id);
    }

}
