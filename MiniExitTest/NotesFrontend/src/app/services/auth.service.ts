import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root',
})
export class AuthService {
  isLoggedIn = false;
  user: any;

  login() {
    console.warn("logged in");
    this.isLoggedIn = true
  }

  setUser(user: any): void {
    this.user = user!;
  }

  getUser(): any{
    return this.user;
  }

  logout(): void {
    console.warn("logging out");
    this.user = undefined;
    this.isLoggedIn = false;
  }
}
