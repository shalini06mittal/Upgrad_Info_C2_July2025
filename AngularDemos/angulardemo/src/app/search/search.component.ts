import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-search',
  standalone: false,
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent {

  @Input()
  author:string = ''
  @Output()
  emitAuthor:EventEmitter<string> = new EventEmitter();

  
  send(author:string){
    
    console.log(author);
    this.emitAuthor.emit(author);
  }
}
