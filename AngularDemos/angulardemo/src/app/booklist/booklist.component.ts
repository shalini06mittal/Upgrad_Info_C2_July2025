import { Component } from '@angular/core';
import { Book } from '../model/Book';
import { books } from '../model/data';

@Component({
  selector: 'app-booklist',
  standalone: false,
  templateUrl: './booklist.component.html',
  styleUrl: './booklist.component.css'
})
export class BooklistComponent {

    blist:Book[] = [];

    

    constructor(){
      this.blist= books;
    }
    searchBooks(author:any){
      console.log('value emitted to booklist',author);
      if(author.toLowerCase()==='all')
        this.blist = books
     
      else
      this.blist = 
      books.filter(book => book.author.toLowerCase() === author.toLowerCase())
    }
}
