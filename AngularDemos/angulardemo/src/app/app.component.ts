import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Welcome To Angualar';
  desc = "Content "
  enabled:boolean=false;
  getName(){
  
    return "Shalini";
  }
  change(){
    this.enabled =!this.enabled
    console.log(this.enabled)
  }
}
