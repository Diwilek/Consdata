package pl.consdata.rekrutacja.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopHeadlinesApiResponse {

    private List<ArticleApiResponse> articles;

}
