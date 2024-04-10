package pl.consdata.rekrutacja.backend.news.mapper;

import org.junit.jupiter.api.Test;
import pl.consdata.rekrutacja.backend.mapper.ApiMapper;
import pl.consdata.rekrutacja.backend.mapper.ApiMapperImpl;
import pl.consdata.rekrutacja.backend.model.Article;
import pl.consdata.rekrutacja.backend.model.ArticleApiResponse;
import pl.consdata.rekrutacja.backend.model.SourceApiResponse;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiMapperTest {

    private ApiMapper apiMapper = new ApiMapperImpl();

    @Test
    void shouldMapArticle(){
        //given
        ArticleApiResponse response = ArticleApiResponse.builder()
                .url("http://localhost/url")
                .title("title")
                .author("author")
                .content("content")
                .description("desc")
                .publishedAt(LocalDate.of(2022,12,12))
                .source(SourceApiResponse.builder()
                        .id("id")
                        .name("name")
                        .build())
                .urlToImage("http://localhost/image")
                .build();

        //when
        Article result = apiMapper.map(response);

        //then
        assertThat(result).isNotNull();
        assertThat(result.getDate()).isEqualTo(LocalDate.of(2022,12,12));
        assertThat(result.getArticleUrl()).isEqualTo("http://localhost/url");
        assertThat(result.getAuthor()).isEqualTo("author");
        assertThat(result.getTitle()).isEqualTo("title");
        assertThat(result.getDescription()).isEqualTo("desc");
        assertThat(result.getImageUrl()).isEqualTo("http://localhost/image");
        assertThat(result.getSourceName()).isEqualTo("name");
    }

}
