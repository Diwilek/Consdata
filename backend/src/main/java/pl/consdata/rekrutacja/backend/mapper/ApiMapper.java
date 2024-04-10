package pl.consdata.rekrutacja.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.consdata.rekrutacja.backend.model.Article;
import pl.consdata.rekrutacja.backend.model.ArticleApiResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApiMapper {

    @Mapping(source = "source.name", target = "sourceName")
    @Mapping(source = "url", target = "articleUrl")
    @Mapping(source = "publishedAt", target = "date")
    @Mapping(source = "urlToImage", target = "imageUrl")
    Article map(ArticleApiResponse article);

    List<Article> map(List<ArticleApiResponse> articles);

}
