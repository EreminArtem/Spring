package ru.eremin.spring.commercial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.eremin.spring.commercial.configuration.AppConfiguration;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
    }
}
