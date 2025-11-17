import { Component, EventEmitter, HostListener, OnDestroy, OnInit, Output } from '@angular/core';
import { Book } from '../model/Book';

@Component({
  selector: 'app-templateform',
  standalone: false,
  templateUrl: './templateform.component.html',
  styleUrl: './templateform.component.css'
})
export class TemplateformComponent implements OnInit{
  

  @HostListener('window:beforeunload', ['$event'])
  beforeUnloadHandler(){
    sessionStorage.setItem("book", JSON.stringify(this.book));
  }

  ngOnInit(): void {
    let book = sessionStorage.getItem("book");
    if(book){
      console.log(book)
      this.book = JSON.parse(book);
    }
  }

  book:Book = {bookid:0, title:'', author:'', price:0.0,desc:''};

  @Output()
  emitBookAdded : EventEmitter<Book> = new EventEmitter();
  addBook(newBook:Book){
    console.log(newBook)
    
    this.emitBookAdded.emit(newBook);
  }


}
