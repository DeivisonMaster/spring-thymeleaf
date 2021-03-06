package br.com.thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**  
 * Classe responsável por configurar o local e prefixo do ViewResolver JSP
 * @author Deivison
 * */
@Configuration
public class JspConfig {

	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setOrder(2);
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/templates");
		viewResolver.setViewNames(new String[] {"*.jsp"});
		return viewResolver;
	}
}
