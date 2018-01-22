package br.com.msf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.msf.converter.LocalDateConverter;

/**
 * Classe que inicia a aplicacao atraves do Spring Boot
 * 
 * @author Márcio Simon
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Application {
	public static void main(String[] args) {
		// Inicializa a aplicacao
		SpringApplication.run(Application.class, args);
	}
	
    @Configuration
    static class MyConfig extends WebMvcConfigurerAdapter {
		@Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addConverter(new LocalDateConverter("dd/MM/yyyy"));
        }
		
		@Override
		public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		    //registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
		}
    }

}