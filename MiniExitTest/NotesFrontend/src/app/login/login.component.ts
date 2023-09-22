import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { AuthService } from '../services/auth.service';
import { User } from '../model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.pattern("[a-zA-Z0-9 ]*")])
  });


  get email() { return this.loginForm.get('email') }
  get password() { return this.loginForm.get('password') }

constructor(private auth: AuthService, private user: UserService, private router : Router) { }

  error = false
  response: any

  loginUser() {

    console.warn(this.loginForm.value)

    this.response = this.loginForm.value

   
      this.error = false

      this.user.verifyUser(this.response).subscribe((result:any) => {
     
        if(result["success"]){
          this.auth.login();
          this.user.getUser(this.email?.value).subscribe((data:any)=>{
            
            this.auth.setUser(data["data"])
            this.router.navigate(['/home']);

          });
          
        }else{
          this.error = true
          
          alert("Invalid Credentials")
          console.warn("Invalid Credentials")

        }

      })

    
  }


}
