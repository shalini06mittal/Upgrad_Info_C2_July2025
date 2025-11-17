import { Component } from '@angular/core';
import { Book } from './model/Book';
import { DemoService } from './services/demo.service';

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
  username:string = 'Guest'
  book:any;
  show:boolean= false;

  constructor(public demo:DemoService){}
  getName(){
  
    return "Shalini";
  }
  change(){
    this.enabled =!this.enabled
    this.title = 'Is Enabled value '+ this.enabled;
    console.log(this.enabled)
  }
  updateUsername(event:any){
    this.username = event.target.value;
  }
  addNewBook(newBook:Book){
      this.book = newBook;
  }
  toggle(){
    this.show = !this.show
  }
}
