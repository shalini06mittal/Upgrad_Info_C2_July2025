import { Component, DoCheck, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-child',
  standalone: false,
  templateUrl: './child.component.html',
  styleUrl: './child.component.css'
})
export class ChildComponent implements OnInit, OnChanges, DoCheck{
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
    console.log(`child constructor ${JSON.stringify(this.employee)}`);
  }
  ngDoCheck(): void {
     console.log(`child do check ${this.country}`);
    console.log(`child do check ${JSON.stringify(this.employee)}`);
  }
  ngOnChanges(changes: SimpleChanges): void {
     console.log(`child on changes ${this.country}`);
    console.log(`child on changes ${JSON.stringify(this.employee)}`);
    this.countrystates = 
    this.data.filter(item => item.country === this.country)
    console.log(this.countrystates)
  }
  i=1;
  interval:any;
  ngOnInit(): void {
    console.log(`child ng on init ${this.country}`);
    console.log(`child ng on init ${JSON.stringify(this.employee)}`);
    //this.interval = setInterval(()=> console.log(this.i++), 1000);
  }
  // it is invoked only first time the component is loaded
  ngOnDestroy(): void {
    console.log(`child destroy`);
    //clearInterval(this.interval);
  }
}
