package pl.consdata.rekrutacja.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.consdata.rekrutacja.backend.model.TopHeadlinesResponse;
import pl.consdata.rekrutacja.backend.service.NewsService;

@RestController
@RequestMapping("/news/")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("{country}/{category}")
    public TopHeadlinesResponse getTopHeadlines(@PathVariable final String country, @PathVariable final String category) {
        return newsService.getNews(country,category);
    }

}
