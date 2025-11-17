import { Component } from '@angular/core';
import { PostService } from '../http/post.service';

@Component({
  selector: 'app-addpost',
  standalone: false,
  templateUrl: './addpost.component.html',
  styleUrl: './addpost.component.css'
})
export class AddpostComponent {

  constructor(private ps:PostService){}

  addPost(post:any){
    console.log(post)
    this.ps.addPost(post).subscribe(res => console.log(res))
  }


}
