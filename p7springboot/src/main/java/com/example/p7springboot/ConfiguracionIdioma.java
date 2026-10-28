package com.example.p7springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

// se configura el idioma
@Configuration
public class ConfiguracionIdioma implements WebMvcConfigurer {

    // guarda idioma en sesion, predeterminado español
    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver resolvedor = new SessionLocaleResolver();
        resolvedor.setDefaultLocale(Locale.forLanguageTag("es"));
        return resolvedor;
    }

    // lee parametro lang y cambia idioma
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(localeChangeInterceptor());
    }

}
