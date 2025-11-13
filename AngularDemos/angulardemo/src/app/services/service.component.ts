import { Component } from '@angular/core';
import { DemoService } from './demo.service';

@Component({
  selector: 'app-service',
  standalone: false,
  templateUrl: './service.component.html',
  styleUrl: './service.component.css',
  providers:[DemoService]
})
export class ServiceComponent {

  constructor(public demo:DemoService){

  }
}
