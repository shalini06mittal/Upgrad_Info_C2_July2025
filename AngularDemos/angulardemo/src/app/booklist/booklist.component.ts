import { Component } from '@angular/core';

@Component({
  selector: 'app-booklist',
  standalone: false,
  templateUrl: './booklist.component.html',
  styleUrl: './booklist.component.css'
})
export class BooklistComponent {

    blist:any[] = [];

    constructor(){
      this.blist=[
        {bookid:1, title:'Midnight Sky', author:'Sydney', desc:'Enjoy the suspense', price: 23.89},
        {bookid:2, title:'Philosophers Stone', author:'J.K. Rowling', desc:'Enjoy the adventures', price: 123.89}
      ]
    }

}
