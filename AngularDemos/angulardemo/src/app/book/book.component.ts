import { Component, Input } from '@angular/core';
import { Book } from '../model/Book';

@Component({
  selector: 'app-book',
  standalone: false,
  templateUrl: './book.component.html',
  styleUrl: './book.component.css'
})
export class BookComponent {

  @Input()
  book:Book = {bookid:0, title:'', author:'', price:0.0,desc:''};

  constructor(){

  }
}
