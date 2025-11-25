import { CanActivateFn, Router } from '@angular/router';
import { UserService } from '../http/user.service';
import { inject } from '@angular/core';

export const authGuard: CanActivateFn = (route, state) => {

  const us: UserService = inject(UserService);
  const router:Router = inject(Router);

  if(us.isAuthenticated())
    return true;
  console.log('auth guard');
  alert('Please Login');
  router.navigate(['login']);
  return false;
};
