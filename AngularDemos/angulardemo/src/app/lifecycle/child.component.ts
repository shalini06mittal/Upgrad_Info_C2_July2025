import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-child',
  standalone: false,
  templateUrl: './child.component.html',
  styleUrl: './child.component.css'
})
export class ChildComponent {
  @Input()
  country: string = 'uk';
  @Input()
  employee = { "name": "" };
  data: any[] = [
    { "country": "uk", "states": ["London"] },
    { "country": "india", "states": ["maharashtra", "UP", "MP"] },
    { "country": "ireland", "states": ["ire1", "ire2"] },
    { "country": "usa", "states": ["Illinois", "SFO"] }
  ]
  countrystates: any[] = []

  constructor() {
    console.log(`child constructor ${this.country}`);
  }

  ngOnInit(): void {
    console.log(`child ng on init ${this.country}`);
  }
  // it is invoked only first time the component is loaded
  ngOnDestroy(): void {
    console.log(`child destroy`);
  }
}
