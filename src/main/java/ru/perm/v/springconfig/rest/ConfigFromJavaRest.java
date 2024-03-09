package ru.perm.v.springconfig.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo for @Configuration and @Bean
 * from ru.perm.v.camelinaction.ch2.conf.SimpleJavaConfig
 * <p/>
 * beens <b>beanOneFromSimpleJavaConfig</b> and <b>beanTwoFromSimpleJavaConfig</b> defined
 * in <b>SimpleJavaConfig</b>
 */
@RestController
@RequestMapping("/simple_conf")
public class ConfigFromJavaRest {
    @Autowired
    String beanOneConfigFromJava;

    @Autowired
    String beanTwoConfigFromJava;

    /**
     * http :8080/api/simple_conf/bean_one
     * @return beanOne
     */
    @GetMapping("/bean_one")
    public String beanOne() {
        return beanOneConfigFromJava;
    }

    /**
     * http :8080/api/simple_conf/bean_two
     * @return beanTwo
     */
    @GetMapping("/bean_two")
    public String beanTwo() {
        return beanTwoConfigFromJava;
    }
}
