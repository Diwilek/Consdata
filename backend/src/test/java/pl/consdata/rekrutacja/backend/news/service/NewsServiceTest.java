package pl.consdata.rekrutacja.backend.news.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.consdata.rekrutacja.backend.client.NewsClient;
import pl.consdata.rekrutacja.backend.mapper.ApiMapper;
import pl.consdata.rekrutacja.backend.model.Article;
import pl.consdata.rekrutacja.backend.model.ArticleApiResponse;
import pl.consdata.rekrutacja.backend.model.TopHeadlinesApiResponse;
import pl.consdata.rekrutacja.backend.model.TopHeadlinesResponse;
import pl.consdata.rekrutacja.backend.service.NewsService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class NewsServiceTest {

    @Mock
    private NewsClient newsClient;
    @Mock
    private ApiMapper apiMapper;
    @InjectMocks
    private NewsService newsService;

    @Test
    void shouldGetNews() {
        //given
        String country = "pl";
        String category = "sport";
        TopHeadlinesApiResponse apiResult = new TopHeadlinesApiResponse();
        apiResult.setArticles(Arrays.asList(new ArticleApiResponse()));

        List<Article> articles = Arrays.asList(new Article());
        Mockito.when(newsClient.callForNews(country, category)).thenReturn(apiResult);
        Mockito.when(apiMapper.map(apiResult.getArticles())).thenReturn(articles);

        //when
        TopHeadlinesResponse result = newsService.getNews(country, category);

        //then
        assertThat(result).isNotNull();
        assertThat(result.getCountry()).isEqualTo(country);
        assertThat(result.getCategory()).isEqualTo(category);
        assertThat(result.getArticles()).isNotNull();
        assertThat(result.getArticles().size()).isEqualTo(1);
    }

}
