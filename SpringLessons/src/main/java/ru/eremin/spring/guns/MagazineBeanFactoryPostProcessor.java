package ru.eremin.spring.guns;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import ru.eremin.spring.guns.annotations.UnproducableMagazine;

@Component
public class MagazineBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (final String name : names) {
            final BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            final String className = beanDefinition.getBeanClassName();
            try {
                final Class<?> beanClass = Class.forName(className);
                final UnproducableMagazine annotation = beanClass.getAnnotation(UnproducableMagazine.class);
                if (annotation != null) {
                    final Class usingMagazine = annotation.usingMagazine();
                    beanDefinition.setBeanClassName(usingMagazine.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
