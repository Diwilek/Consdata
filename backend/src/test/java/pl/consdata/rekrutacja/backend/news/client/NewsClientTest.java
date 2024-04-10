package pl.consdata.rekrutacja.backend.news.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import pl.consdata.rekrutacja.backend.client.NewsClient;
import pl.consdata.rekrutacja.backend.config.NewsApiPropertiesConfig;
import pl.consdata.rekrutacja.backend.model.TopHeadlinesApiResponse;

@ExtendWith(MockitoExtension.class)
public class NewsClientTest {

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private NewsApiPropertiesConfig newsApiPropertiesConfig;
    @InjectMocks
    private NewsClient newsClient;

    @Test
    void shouldCallForNews(){
        //given
        String country = "no";
        String category = "sports";
        var headers  = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer key");
        ResponseEntity<TopHeadlinesApiResponse> response = Mockito.mock(ResponseEntity.class);
        Mockito.when(newsApiPropertiesConfig.getUrl()).thenReturn("http://localhost");
        Mockito.when(newsApiPropertiesConfig.getApikey()).thenReturn("key");
        Mockito.when(restTemplate.exchange("http://localhost/v2/top-headlines?country=no&category=sports",
                HttpMethod.GET, new HttpEntity<>(headers), TopHeadlinesApiResponse.class, country, category))
                .thenReturn(response);

        //when
        newsClient.callForNews(country, category);

        //then
        Mockito.verify(response, Mockito.timeout(1)).getBody();
    }

}
