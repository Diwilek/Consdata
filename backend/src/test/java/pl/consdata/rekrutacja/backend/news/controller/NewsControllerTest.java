package pl.consdata.rekrutacja.backend.news.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
class NewsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final WireMockServer wireMockServer = new WireMockServer(9090);

    @BeforeEach
    void setup(){
        wireMockServer.start();
    }

    @Test
    void shouldGetNews() throws Exception {
        wireMockServer.givenThat(com.github.tomakehurst.wiremock.client.WireMock.get(urlPathMatching("/v2/top-headlines"))
                .withQueryParam("country", equalTo("pl"))
                .withQueryParam("category", equalTo("testCategory"))
                        .withHeader(HttpHeaders.AUTHORIZATION, equalTo("Bearer testApiKey"))
                .willReturn(okJson("{\n" +
                        "  \"articles\": [\n" +
                        "    {\n" +
                        "      \"source\": {\n" +
                        "        \"id\": \"google-news\",\n" +
                        "        \"name\": \"Google News\"\n" +
                        "      },\n" +
                        "      \"author\": \"VG\",\n" +
                        "      \"title\": \"Guro Reiten visste ikke hvem landslagssjefen Gemma Grainger var - VG\",\n" +
                        "      \"description\": \"example description\",\n" +
                        "      \"url\": \"https://news.google.com/rss/articles/CBMiaGh0dHBzOi8vd3d3LnZnLm5vL3Nwb3J0L2ZvdGJhbGwvaS80b25XeXEvZ3Vyby1yZWl0ZW4tdmlzc3RlLWlra2UtaHZlbS1sYW5kc2xhZ3NzamVmZW4tZ2VtbWEtZ3JhaW5nZXItdmFy0gEA?oc=5\",\n" +
                        "      \"urlToImage\": \"http://localhost/imageUrl\",\n" +
                        "      \"publishedAt\": \"2024-04-04T15:51:22Z\",\n" +
                        "      \"content\": \"example content\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}"))
        );

        mockMvc.perform(get("/news/pl/testCategory"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.country").value("pl"))
                .andExpect(jsonPath("$.category").value("testCategory"))
                .andExpect(jsonPath("$.articles", hasSize(1)))
                .andExpect(jsonPath("$.articles[0].author").value("VG"))
                .andExpect(jsonPath("$.articles[0].title").value("Guro Reiten visste ikke hvem landslagssjefen Gemma Grainger var - VG"))
                .andExpect(jsonPath("$.articles[0].description").value("example description"))
                .andExpect(jsonPath("$.articles[0].date").value("2024-04-04"))
                .andExpect(jsonPath("$.articles[0].sourceName").value("Google News"))
                .andExpect(jsonPath("$.articles[0].articleUrl").value("https://news.google.com/rss/articles/CBMiaGh0dHBzOi8vd3d3LnZnLm5vL3Nwb3J0L2ZvdGJhbGwvaS80b25XeXEvZ3Vyby1yZWl0ZW4tdmlzc3RlLWlra2UtaHZlbS1sYW5kc2xhZ3NzamVmZW4tZ2VtbWEtZ3JhaW5nZXItdmFy0gEA?oc=5"))
                .andExpect(jsonPath("$.articles[0].imageUrl").value("http://localhost/imageUrl"));
    }

}
