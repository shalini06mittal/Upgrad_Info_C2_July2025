import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../model/Book';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  url:string = 'http://localhost:8081/books'
  constructor(private http:HttpClient) { }

  getBooks():Observable<Book[]>{
    return this.http.get<Book[]>(`${this.url}`)
  }

  addBook(book:Book):Observable<Book>{
    return this.http.post<Book>(this.url, book);
  }

  getBookById(id:number):Observable<any>{
    return this.http.get<any>(this.url+'/'+id);
  }
 
}
