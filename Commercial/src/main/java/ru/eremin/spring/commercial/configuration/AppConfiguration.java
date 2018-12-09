package ru.eremin.spring.commercial.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import(DataSourceConfiguration.class)
@EnableJpaRepositories("ru.eremin.spring.commercial.repository")
@ComponentScan("ru.eremin.spring.commercial")
public class AppConfiguration {
}
