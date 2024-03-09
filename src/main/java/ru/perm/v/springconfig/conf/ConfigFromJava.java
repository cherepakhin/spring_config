package ru.perm.v.springconfig.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is a variant define configuration with annotation @Configuration and @Bean.
 *<p/><p/
 * (other variant is ru.perm.v.camelinaction.ch2.conf.BeansConfiguration
 * used in ru.perm.v.camelinaction.ch2.SimpleJavaConfigRest)
 */
@Configuration
public class ConfigFromJava {
    @Bean
    public String beanOneConfigFromJava() {
        return "beanOne";
    }

    @Bean
    public String beanTwoConfigFromJava() {
        return "beanTwo";
    }
}
