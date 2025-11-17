import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TemplateformComponent } from './templateform/templateform.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { BooklistComponent } from './booklist/booklist.component';

const routes: Routes = [
  {path:'', component:BooklistComponent},
  {path:'add', component:TemplateformComponent},
  {path:'login', component:LoginComponent},
  {path:'register', component:RegisterComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
