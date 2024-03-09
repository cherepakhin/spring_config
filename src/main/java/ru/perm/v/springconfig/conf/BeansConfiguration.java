package ru.perm.v.springconfig.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Configuration from beans.xml
 * <p>
 * To project injected beans: russianGreeter, germanyGreeter, englishGreeter, selectedGreeterService.
 * <p/>
 * This beans will be available with @Autowired
 */
@Configuration
@ImportResource({"classpath*:beans.xml"})
public class BeansConfiguration {
}
