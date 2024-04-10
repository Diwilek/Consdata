package pl.consdata.rekrutacja.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private String author;
    private String title;
    private String description;
    private LocalDate date;
    private String sourceName;
    private String articleUrl;
    private String imageUrl;
}
