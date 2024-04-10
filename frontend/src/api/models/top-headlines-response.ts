/* tslint:disable */
import { Article } from './article';
export interface TopHeadlinesResponse {
  articles?: Array<Article>;
  category?: string;
  country?: string;
}
