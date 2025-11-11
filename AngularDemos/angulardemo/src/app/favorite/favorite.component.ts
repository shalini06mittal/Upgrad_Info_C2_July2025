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
    let obj = books.find(item => item.bookid === this.favid);
    console.log(obj);
    // book.isFavorite = !book.isFavorite;

    // // 2. Add or remove the book from the favoriteBooks list
    // if (book.isFavorite) {
    //   // Add to favorites if not already present
    //   if (!this.favoriteBooks.some(fav => fav.id === book.id)) {
    //     this.favoriteBooks.push(book);
    //   }
    // } else {
    //   // Remove from favorites if present
    //   const index = this.favoriteBooks.findIndex(fav => fav.id === book.id);
    //   if (index !== -1) {
    //     this.favoriteBooks.splice(index, 1);
    //   }
    // }
    // console.log(this.favid)
    
    // console.log(obj);
    // // if(obj){
    // //   this.favlist = this.favlist.filter(book => book !== obj);
    // // }
    // if(this.favlist.length==0){
    //   let book = books.find(item => item.bookid === this.favid);
    //       if(book!== undefined)
    //         this.favlist.push(book);
    // }
    //   for(let i=0;i<this.favlist.length;i++){
    //     if(this.favlist[i].bookid !== this.favid){
    //       let book = books.find(item => item.bookid === this.favid);
    //       if(book!== undefined){
    //         this.favlist.push(book);
    //         break;
    //       }
    //     }
    //   }
  }

}
