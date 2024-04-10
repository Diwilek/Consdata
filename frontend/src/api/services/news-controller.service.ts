/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { TopHeadlinesResponse } from '../models/top-headlines-response';

/**
 * News Controller
 */
@Injectable({
  providedIn: 'root',
})
class NewsControllerService extends __BaseService {
  static readonly getTopHeadlinesUsingGETPath = '/news/{country}/{category}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * getTopHeadlines
   * @param params The `NewsControllerService.GetTopHeadlinesUsingGETParams` containing the following parameters:
   *
   * - `country`: country
   *
   * - `category`: category
   *
   * @return OK
   */
  getTopHeadlinesUsingGETResponse(params: NewsControllerService.GetTopHeadlinesUsingGETParams): __Observable<__StrictHttpResponse<TopHeadlinesResponse>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;


    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/news/${encodeURIComponent(String(params.country))}/${encodeURIComponent(String(params.category))}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<TopHeadlinesResponse>;
      })
    );
  }
  /**
   * getTopHeadlines
   * @param params The `NewsControllerService.GetTopHeadlinesUsingGETParams` containing the following parameters:
   *
   * - `country`: country
   *
   * - `category`: category
   *
   * @return OK
   */
  getTopHeadlinesUsingGET(params: NewsControllerService.GetTopHeadlinesUsingGETParams): __Observable<TopHeadlinesResponse> {
    return this.getTopHeadlinesUsingGETResponse(params).pipe(
      __map(_r => _r.body as TopHeadlinesResponse)
    );
  }
}

module NewsControllerService {

  /**
   * Parameters for getTopHeadlinesUsingGET
   */
  export interface GetTopHeadlinesUsingGETParams {

    /**
     * country
     */
    country: string;

    /**
     * category
     */
    category: string;
  }
}

export { NewsControllerService }
