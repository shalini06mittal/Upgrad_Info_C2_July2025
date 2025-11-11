import { Component } from '@angular/core';
import { Book } from '../model/Book';

@Component({
  selector: 'app-templateform',
  standalone: false,
  templateUrl: './templateform.component.html',
  styleUrl: './templateform.component.css'
})
export class TemplateformComponent {
  book:Book = {bookid:0, title:'', author:'', price:0.0,desc:''};

  addBook(newBook:Book){
    console.log(newBook)
  }
}
