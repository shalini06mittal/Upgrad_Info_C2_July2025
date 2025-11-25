import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../http/user.service';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  public loginValid = true;
  public email = 'shalini@gmail.com';
  public password = 'shalini';
  constructor(private router: Router, private userserv: UserService) { }
  /**
  * when user click on login button, get token for valid credentials and redirect to home page
  * or display an error message for invalid credentials and remain on login page
  */
  public onSubmit(): void {
    this.loginValid = true;
    console.log('login', this.email, this.password)
    this.userserv.loginUser(this.email, this.password)
      .subscribe({
        next: resp => {
          console.log(resp);
          if (resp === true) {
            localStorage.setItem("email", this.email);
            this.router.navigate(['']);
          }
          else
            this.loginValid = false
        },
        error: err => this.loginValid = false
      });
  }
}
