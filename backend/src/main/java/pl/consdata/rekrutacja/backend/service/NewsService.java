package pl.consdata.rekrutacja.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.consdata.rekrutacja.backend.client.NewsClient;
import pl.consdata.rekrutacja.backend.mapper.ApiMapper;
import pl.consdata.rekrutacja.backend.model.TopHeadlinesApiResponse;
import pl.consdata.rekrutacja.backend.model.TopHeadlinesResponse;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsClient newsClient;
    private final ApiMapper apiMapper;

    public TopHeadlinesResponse getNews(String country, String category) {
        TopHeadlinesApiResponse response = newsClient.callForNews(country, category);
        return TopHeadlinesResponse.builder()
                .articles(apiMapper.map(response.getArticles()))
                .country(country)
                .category(category)
                .build();
    }

}
