package pl.consdata.rekrutacja.backend.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "newsapiorg")
@Getter
@Setter

public class NewsApiPropertiesConfig {

    private String url;
    private String apikey;

}
