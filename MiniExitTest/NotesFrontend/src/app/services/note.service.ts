
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { API } from "../constants";



@Injectable({
    providedIn: 'root'
})

export class NoteService {
   
    api = API + "notes";

    constructor(private http: HttpClient) { }

    addNote(data: any) {
        return this.http.post(this.api + "/create", data);
    }

    getNotesByUId(uid: any) {
        return this.http.get(this.api + "/by/" + uid);
    }
    
    getNoteById(id: any) {
        return this.http.get(this.api + "/" + id);
    }

    deleteNote(id: any) {
        return this.http.delete(this.api + "/" + id);
    }


}
