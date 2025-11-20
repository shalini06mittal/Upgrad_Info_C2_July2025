import { Component, Input, OnInit } from '@angular/core';
import { Book } from '../model/Book';
import { ActivatedRoute } from '@angular/router';
import { BookService } from '../http/book.service';

@Component({
  selector: 'app-book',
  standalone: false,
  templateUrl: './book.component.html',
  styleUrl: './book.component.css'
})
export class BookComponent implements OnInit {

  //@Input()
  book:Book = {bookid:0, title:'', author:'', price:0.0,desc:''};

  constructor(private route:ActivatedRoute, private bs:BookService){

  }
  ngOnInit(): void {
   this.route.params.subscribe(data=> {
    console.log(data)
    let id = parseInt(data['id'])
    console.log(id)
    this.bs.getBookById(id).subscribe(bk=> {
      console.log(bk);
      this.book= bk.book
   })
   }
  );
  }

}
