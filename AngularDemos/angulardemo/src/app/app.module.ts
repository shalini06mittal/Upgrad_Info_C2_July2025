import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BooklistComponent } from './booklist/booklist.component';
import { PipesComponent } from './pipes/pipes.component';
import { ReversePipe } from './pipes/reverse.pipe';
import { SearchComponent } from './search/search.component';
import { LifecycleComponent } from './lifecycle/lifecycle.component';
import { ChildComponent } from './lifecycle/child.component';
import { BookComponent } from './book/book.component';
import { FavoriteComponent } from './favorite/favorite.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    BooklistComponent,
    PipesComponent,
    ReversePipe,
    SearchComponent,
    LifecycleComponent,
    ChildComponent,
    BookComponent,
    FavoriteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
