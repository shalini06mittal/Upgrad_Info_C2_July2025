import { Component, OnInit } from '@angular/core';
import { UserService } from '../http/user.service';

@Component({
  selector: 'app-post',
  standalone: false,
  templateUrl: './post.component.html',
  styleUrl: './post.component.css'
})
export class PostComponent implements OnInit{

  posts:any = undefined;
  constructor(private us:UserService){

  }
  ngOnInit(): void {
    this.getPostData();
  }

  getPostData(){
      this.us.getPosts()
      .subscribe((posts: any) => {
        console.log(posts);
        this.posts = posts;
    });
  }

}
