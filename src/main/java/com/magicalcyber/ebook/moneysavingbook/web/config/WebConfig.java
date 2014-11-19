package com.magicalcyber.ebook.moneysavingbook.web.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;
import java.util.Properties;

/**
 * Contains controllers, view resolvers, locale resolvers, and other web-related
 * beans.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.magicalcyber.ebook.moneysavingbook.web"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/").addResourceLocations(
                "/resources/**");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.put("org.springframework.web.servlet.PageNotFound", "p404");
        mappings.put("org.springframework.dao.DataAccessException", "dataAccessFailure");
        mappings.put("org.springframework.transaction.TransactionException", "dataAccessFailure");
        b.setExceptionMappings(mappings);

        return b;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages/messages");
        messageSource.setCacheSeconds(5);
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver lr = new SessionLocaleResolver();
        lr.setDefaultLocale(Locale.ENGLISH);

        return lr;
    }
}
