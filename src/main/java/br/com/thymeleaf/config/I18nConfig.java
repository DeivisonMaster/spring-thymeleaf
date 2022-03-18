package br.com.thymeleaf.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

/** 
 * Classe responsável por configurar e fixar o idioma do sistema para pt-BR e configura o arquivo de mensagens 
 * @author Deivison
 * */
@Configuration
public class I18nConfig {
	
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
	
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
        
        bundle.setBasename("/WEB-INF/i18n/Mensagens");
        bundle.setDefaultEncoding("UTF-8");
        bundle.setCacheSeconds(1);
        
        return bundle;
    }
	
}
