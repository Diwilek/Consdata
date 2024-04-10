package pl.consdata.rekrutacja.backend.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopHeadlinesResponse {
    private String country;
    private String category;
    @Singular
    private List<Article> articles;
}
