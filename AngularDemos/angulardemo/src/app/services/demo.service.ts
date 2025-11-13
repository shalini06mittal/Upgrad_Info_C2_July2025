import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DemoService {
  message:string;
  constructor() {
    console.log('Demo Service Constructor');
    this.message = 'Hello From Service';
   }
   setMessage(message:string){
    this.message = message;
   }
}
