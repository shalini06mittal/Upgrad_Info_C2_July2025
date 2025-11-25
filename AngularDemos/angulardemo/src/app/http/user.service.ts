import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  loginUser(email:string, password:string):Observable<Boolean>{
    if(email==='shalini@gmail.com' && password==='shalini'){
      return of(true);
    }
      return of(false);
  }

  isAuthenticated():boolean{
    return !!localStorage.getItem('email');
  }
  logout(){
    localStorage.removeItem('email');
  }
}
