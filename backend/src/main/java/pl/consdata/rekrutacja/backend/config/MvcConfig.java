package pl.consdata.rekrutacja.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/news/**")
                .allowedHeaders("*")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET");
    }

}
