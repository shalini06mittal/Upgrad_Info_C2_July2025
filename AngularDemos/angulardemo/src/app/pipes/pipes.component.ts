import { Component } from '@angular/core';
import { Book } from '../model/Book';

@Component({
  selector: 'app-pipes',
  standalone: false,
  templateUrl: './pipes.component.html',
  styleUrl: './pipes.component.css'
})
export class PipesComponent {
    amount: number = 100/3;
    name:string = 'ShaLini'
    book:Book = {bookid:1, title:'Midnight Sky', author:'Sydney',
           desc:'Enjoy the suspense', price: 23.89};
    bdate:Date = new Date();
    nos:number[]=[1,2,3,4,5,6,7,8,9,10]
}
