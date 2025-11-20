import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TemplateformComponent } from './templateform/templateform.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { BooklistComponent } from './booklist/booklist.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { BookComponent } from './book/book.component';

const routes: Routes = [
  {path:'', redirectTo:'books', pathMatch:'full'},
  {path:'books', component:BooklistComponent},
  {path:'books/:id', component:BookComponent},
  {path:'add', component:TemplateformComponent},
  {path:'login', component:LoginComponent},
  {path:'register', component:RegisterComponent},
  {path:'**', component:PagenotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
