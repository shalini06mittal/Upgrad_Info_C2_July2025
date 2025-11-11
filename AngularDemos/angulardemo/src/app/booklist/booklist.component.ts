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

    id:number = 0;
    delid:number = 0;
    favorite:string='Add To Favorite'
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
    addToFavorite(bookid:number){
      this.id = bookid;
      for(let i=0;i<this.blist.length;i++){
        let book = this.blist[i];
          if(book.bookid === this.id){
              book.isFav = !book.isFav;
              if(!book.isFav)
                this.delid = book.bookid
              
          }
      }
    }
}
