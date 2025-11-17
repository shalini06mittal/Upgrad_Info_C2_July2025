import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  url:string = 'https://jsonplaceholder.typicode.com/'
  constructor(private http:HttpClient) { }

  getPosts():any{
    return this.http.get<any>(`${this.url}posts`)
  }

  addPost(post:any){

    post.userId = 2;
    console.log(post)
    console.log(typeof(post))
    return this.http.post<any>(`${this.url}posts`,post)

  }
 
}
