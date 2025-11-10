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

    //ids:number[] = [];
    favlist:Book[] = [];   
    
    constructor(){
        this.favlist = books.filter(item => item.price > 300);
    }
  ngOnChanges(changes: SimpleChanges): void {
    if(this.favlist.length==0){
      let book = books.find(item => item.bookid === this.favid);
          if(book!== undefined)
            this.favlist.push(book);
    }
      for(let i=0;i<this.favlist.length;i++){
        if(this.favlist[i].bookid !== this.favid){
          let book = books.find(item => item.bookid === this.favid);
          if(book!== undefined)
            this.favlist.push(book);
        }
      }
  }

}
