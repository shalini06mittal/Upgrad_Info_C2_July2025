import { Component, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-observable',
  standalone: false,
  templateUrl: './observable.component.html',
  styleUrl: './observable.component.css'
})
export class ObservableComponent implements OnDestroy{
  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  data: Observable<string> | null | undefined;
  fruits: Array<string> = [];
  anyErrors: boolean = false;
  finished: boolean = false;

  sub: any;


  start() {
    this.data = new Observable(observer => {
      setTimeout(() => observer.next('Apple'), 1000),
        setTimeout(() => observer.next('orange'), 2000),
        setTimeout(() => observer.next('Banana'), 4000),
        setTimeout(() => observer.next('Mangoes'), 3000),
        setTimeout(() => observer.complete(), 7000)
    });


    this.sub = this.data.subscribe({
      next:  (fruit:string) => this.fruits.push(fruit),
      error: error => this.anyErrors = true,
      complete: () => this.finished = true
    } 
    )
  }

}
