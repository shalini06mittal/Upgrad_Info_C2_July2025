import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url:string = 'https://jsonplaceholder.typicode.com/'
  constructor(private http:HttpClient) { }

  getPosts():any{
    return this.http.get<any>(`${this.url}posts`)
  }
 
}
