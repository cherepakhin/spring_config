package ru.perm.v.springconfig.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perm.v.springconfig.service.GreeterService;
import ru.perm.v.springconfig.greeters.EnglishGreeter;
import ru.perm.v.springconfig.greeters.GermanyGreeter;
import ru.perm.v.springconfig.greeters.RussianGreeter;

import static java.lang.String.format;

@RestController
@RequestMapping("/greet")
public class BeansConfigurationRest {

    private static final Logger logger = Logger.getLogger(BeansConfigurationRest.class);
    /**
     * inject from beans.xml property <property name="greeter" ref="russianGreeter"/>
     */
    @Autowired
    GreeterService selectedGreeterService;
    @Autowired
    GermanyGreeter germanyGreeter;
    @Autowired
    EnglishGreeter englishGreeter;
    @Autowired
    RussianGreeter russianGreeter;

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable String message) {
        logger.info(format("echo message: %s", message));
        return message;
    }

    @GetMapping("/selected")
    public String getSelectedHello() {
        return selectedGreeterService.getHello();
    }

    @GetMapping("/english")
    public String getEnglishHello() {
        return englishGreeter.sayHello();
    }

    @GetMapping("/germany")
    public String getGermanHello() {
        return germanyGreeter.sayHello();
    }

    @GetMapping("/russian")
    public String getRussianHello() {
        return russianGreeter.sayHello();
    }
}
