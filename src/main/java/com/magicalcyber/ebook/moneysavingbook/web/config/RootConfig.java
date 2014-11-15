package com.magicalcyber.ebook.moneysavingbook.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Contains middle-tier services, data sources, etc.
 */
 
@Configuration
@ComponentScan(basePackages = { "com.magicalcyber.ebook.moneysavingbook.service" })
public class RootConfig {

}
