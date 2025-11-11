import { Component, EventEmitter, Output } from '@angular/core';
import { Book } from '../model/Book';

@Component({
  selector: 'app-templateform',
  standalone: false,
  templateUrl: './templateform.component.html',
  styleUrl: './templateform.component.css'
})
export class TemplateformComponent {
  book:Book = {bookid:0, title:'', author:'', price:0.0,desc:''};

  @Output()
  emitBookAdded : EventEmitter<Book> = new EventEmitter();
  addBook(newBook:Book){
    console.log(newBook)
    
    this.emitBookAdded.emit(newBook);
  }
}
