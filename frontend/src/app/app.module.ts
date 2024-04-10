import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {ArticleListHeaderComponent} from './articles/article-list-header.component';
import { ArticleListComponent } from './article-list/article-list.component';
import { ApiModule } from 'src/api/api.module';

@NgModule({
  declarations: [
    AppComponent,
    ArticleListHeaderComponent,
    ArticleListComponent,
  ],
  imports: [
    BrowserModule,
    ApiModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
