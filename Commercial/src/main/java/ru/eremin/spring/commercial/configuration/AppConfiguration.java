package ru.eremin.spring.commercial.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataSourceConfiguration.class)
@ComponentScan("ru.eremin.spring.commercial")
public class AppConfiguration {
}
