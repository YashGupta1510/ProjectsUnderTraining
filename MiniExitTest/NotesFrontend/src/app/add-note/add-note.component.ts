import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { NoteService } from '../services/note.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from '../model/user';

@Component({
  selector: 'app-add-note',
  templateUrl: './add-note.component.html',
  styleUrls: ['./add-note.component.css']
})
export class AddNoteComponent {

  constructor(private auth: AuthService, private noteService: NoteService, private router : Router) { }


  noteForm= new FormGroup({
    body :new FormControl('', [Validators.required, Validators.maxLength(500), Validators.pattern('^[a-zA-Z0-9 ,.@;&*+\\-]*$')]),
  })

  get body(){return this.noteForm.get('body');}

  user : User | undefined;
  ngOnInit() : void{
    this.user = this.auth.getUser();
    
  }

  onSubmit(){
    if(this.body?.value && this.user != undefined){
      let data = {
        "body": this.body.value,
        "user": this.user
      }
      
      this.noteService.addNote(data).subscribe(()=>{
        this.router.navigate(['/home']);
      });
    }
  }
}
