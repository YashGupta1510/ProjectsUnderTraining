import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { NoteService } from '../services/note.service';
import { Note } from '../model/Note';

@Component({
  selector: 'app-list-notes',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  notes: Array<Note> | undefined;

  constructor(private auth: AuthService, private userService: UserService, private noteService: NoteService , private router : Router) { }
  uid: String | null | undefined;
  ngOnInit() : void{
    this.uid = this.auth.getUser()!['email'];
    if(typeof(this.uid) == null){
      this.router.navigate(["/login"]);
    }
    this.noteService.getNotesByUId(this.uid).subscribe((response: any) => {
      if(response["success"]){
        this.notes = response["data"];
        console.log(this.notes)
      }else{
        console.warn(response["message"]);
      }
    });
  }



  delete(id: string){
    sessionStorage.setItem("id", id);
    this.noteService.deleteNote(id).subscribe((data:any)=>{
      alert("Note Deleted");
      var i = this.notes?.findIndex((e)=>e.id == id);
      this.notes?.splice(i!, 1)
      this.noteService.getNotesByUId(this.uid).subscribe((response: any) => {
        if(response["success"]){
          this.notes = response["data"];
          console.log(this.notes)
        }else{
          console.warn(response["message"]);
        }
      });
    });
  }

}
