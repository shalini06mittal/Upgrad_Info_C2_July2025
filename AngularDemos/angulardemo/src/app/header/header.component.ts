import { Component } from '@angular/core';
import { UserService } from '../http/user.service';

@Component({
  selector: 'app-header',
  standalone: false,
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  constructor(public us:UserService){}
}
