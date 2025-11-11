import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Book } from '../model/Book';
import { books } from '../model/data';

@Component({
  selector: 'app-favorite',
  standalone: false,
  templateUrl: './favorite.component.html',
  styleUrl: './favorite.component.css'
})
export class FavoriteComponent implements OnChanges{

    @Input()
    favid:number=0;

    @Input()
    delid:number=0;

    //ids:number[] = [];
    favlist:Book[] = [];   
    
    constructor(){
        //this.favlist = books.filter(item => item.price > 300);
    }

  ngOnChanges(changes: SimpleChanges): void {

    let book = books.find(item => item.bookid === this.favid);
    console.log(book);
    
    // // 2. Add or remove the book from the favoriteBooks list
    if (book?.isFav) {
      // Add to favorites if not already present
      if (!this.favlist.some(fav => fav.bookid === this.favid)) {
        this.favlist.push(book);
      }
    } else {
      // Remove from favorites if present
      const index = this.favlist.findIndex(fav => fav.bookid === book?.bookid);
      if (index !== -1) {
        this.favlist.splice(index, 1);
      }
    }
    
  }

}
