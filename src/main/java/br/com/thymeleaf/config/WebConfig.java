package br.com.thymeleaf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.thymeleaf.SpringWebInitializer;


/**
 * Classe responsável por configurar o local dos recursos da aplicação
 * @author Deivison
 * */
@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = SpringWebInitializer.class)
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }
    
}
