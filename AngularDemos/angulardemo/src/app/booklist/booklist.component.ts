import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Book } from '../model/Book';
import { books } from '../model/data';
import { BookService } from '../http/book.service';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-booklist',
  standalone: false,
  templateUrl: './booklist.component.html',
  styleUrl: './booklist.component.css'
})
export class BooklistComponent implements OnChanges, OnInit{

    blist:Book[] = [];

    @Input()
    newBook:Book =  {bookid:0, title:'', author:'', price:0.0,desc:''};

    id:number = 0;
    delid:number = 0;
    favorite:string='Add To Favorite'
    constructor(private bs:BookService, private router:Router, private route:ActivatedRoute){
     // this.blist= books;
    }
  ngOnInit(): void {
      this.bs.getBooks().subscribe(data => this.blist =data)
  }
  ngOnChanges(changes: SimpleChanges): void {
    this.newBook.bookid = books.length+1;
    books.push(this.newBook);
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

    getBookDetails(id:number){
      console.log(id)

      this.router.navigate([id], {relativeTo:this.route})

    }
}
