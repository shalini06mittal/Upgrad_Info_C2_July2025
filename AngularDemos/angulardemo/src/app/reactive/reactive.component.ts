import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { hasExclamationMark } from '../validator/password';

@Component({
  selector: 'app-reactive',
  standalone: false,
  templateUrl: './reactive.component.html',
  styleUrl: './reactive.component.css'
})
export class ReactiveComponent {

    title = new FormControl('Core Java',
       [Validators.required,Validators.pattern('^[a-zA-Z ]*$')]);
      password = new FormControl('', [hasExclamationMark
        , Validators.required
      ]);
    bookform = new FormGroup({
      title:this.title,
      author: new FormControl('',
        [Validators.required, Validators.minLength(8)]),
        password:this.password
    })
}
