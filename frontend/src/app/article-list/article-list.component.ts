import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { TopHeadlinesResponse } from 'src/api/models';
import { NewsControllerService } from 'src/api/services';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.scss']
})
export class ArticleListComponent implements OnInit {

  apiResponse$: Observable<TopHeadlinesResponse>

  constructor(private newsControllerService: NewsControllerService) {

  }

  ngOnInit() {
    this.apiResponse$ = this.newsControllerService.getTopHeadlinesUsingGET({country: "pl", category: 'technology'})
  }

}
