package pl.consdata.rekrutacja.backend.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.consdata.rekrutacja.backend.config.NewsApiPropertiesConfig;
import pl.consdata.rekrutacja.backend.model.TopHeadlinesApiResponse;

@Component
@RequiredArgsConstructor
public class NewsClient {

    private final RestTemplate restTemplate;
    private final NewsApiPropertiesConfig newsApiPropertiesConfig;

    public TopHeadlinesApiResponse callForNews(String country, String category){
        String url = UriComponentsBuilder.fromHttpUrl(newsApiPropertiesConfig.getUrl()+"/v2/top-headlines")
                .queryParam("country", country)
                .queryParam("category", category)
                .build().toUriString();
        var headers  = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + newsApiPropertiesConfig.getApikey());
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers),
                        TopHeadlinesApiResponse.class, country, category)
                .getBody();
    }

}
