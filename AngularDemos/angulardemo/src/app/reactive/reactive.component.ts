import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive',
  standalone: false,
  templateUrl: './reactive.component.html',
  styleUrl: './reactive.component.css'
})
export class ReactiveComponent {

    title = new FormControl('Core Java',
       [Validators.required,Validators.pattern('^[a-zA-Z ]*$')]);
    bookform = new FormGroup({
      title:this.title,
      author: new FormControl('',
        [Validators.required, Validators.minLength(8)])
    })
}
