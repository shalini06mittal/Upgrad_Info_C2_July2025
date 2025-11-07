import { Component } from '@angular/core';

@Component({
  selector: 'app-lifecycle',
  standalone: false,
  templateUrl: './lifecycle.component.html',
  styleUrl: './lifecycle.component.css'
})
export class LifecycleComponent {

  pcountry:string ='usa';
  emp = {"name":"Shalini"};
  show:boolean=false;
  
  // it is invoked only first time the component is loaded
  constructor() { 
    console.log(`parent constructor`);
  }
  // it is invoked only first time the component is loaded
  ngOnInit(): void {
    console.log(`parent ng oninit `);
  }
}
