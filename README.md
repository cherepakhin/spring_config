Различные способы задания конфигурации Spring Beans
----------------

1. [С помощью xml-файла resources/beans.xml](#xml_file)
2. [С помощью @Configuration и @Bean в conf/ConfigFromJava](#configuration)
3. [Запуск проекта](#run_project)

[Примечания](#other)

<a id="xml_file"></a>
### 1. С помощью xml-файла.

Определение bens в [resources/beans.xml](https://github.com/cherepakhin/spring_config/resources/beans.xml):

````xml

<bean id="russianGreeter" class="ru.perm.v.springconfig.greeters.RussianGreeter"/>
<bean id="germanyGreeter" class="ru.perm.v.springconfig.greeters.GermanyGreeter"/>
<bean id="englishGreeter" class="ru.perm.v.springconfig.greeters.EnglishGreeter"/>

<bean id="selectedGreeterService" class="ru.perm.v.springconfig.service.GreeterService">
<property name="greeter" ref="russianGreeter"/>
</bean>
````

Импорт в проект [conf/BeansConfiguration.java](https://github.com/cherepakhin/spring_config/blob/main/src/main/java/ru/perm/v/springconfig/conf/BeansConfiguration.java):

````java
@Configuration
@ImportResource({"classpath*:beans.xml"})
public class BeansConfiguration {
}
````

Или можно так подгрузить и получить bean (закомментировано "For demo test:"):

````java
@SpringBootApplication
public class SpringConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigApplication.class, args);

// For demo test:
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("beans.xml");
//        GreeterService greeterService =
//                (GreeterService) context.getBean("selectedGreeterService");
//        System.out.println(greeterService.getHello()); // Hello, vasi!

    }
}
````

Использование в [ru.perm.v.springconfig.rest.BeansConfigurationRest.java](https://github.com/cherepakhin/spring_config/blob/main/src/main/java/ru/perm/v/springconfig/rest/BeansConfigurationRest.java):


<a id="configuration"></a>
### 2. С помощью @Configuration и @Bean в [conf/ConfigFromJava.java](https://github.com/cherepakhin/spring_config/blob/main/src/main/java/ru/perm/v/springconfig/conf/ConfigFromJava.java). 

````java
@Configuration
public class ConfigFromJava {
    @Bean
    public String beanOneFromConfigFromJava() {
    return "beanOne";
    }

    @Bean
    public String beanTwoFromConfigFromJava() {
        return "beanTwo";
    }
}
````

Использование в [ru.perm.v.springconfig.rest.ConfigFromJavaRest.java](https://github.com/cherepakhin/spring_config/blob/main/src/main/java/ru/perm/v/springconfig/rest/ConfigFromJavaRest.java):

````java
@RestController
@RequestMapping("/simple_conf")
public class ConfigFromJavaRest {

    @Autowired
    String beanTwoFromConfigFromJava;
    @Autowired
    String beanTwoConfigFromJava;
````

### Unit tests

````shell
$ mvn test
````


### Сборка исполняемого jar

````shell
$ mvn package
````

<a id="run_project"></a>
### 3. Запуск проекта:

````shell
java -jar target/springconfig-0.0.1.jar
````

или:

````shell
$ mvn compile exec:java -Dexec.mainClass=ru.perm.v.springconfig.SpringConfigApplication
````

<a id="other"></a>
### Примечания:

Удален WARNING "172 [main] WARN org.springframework.beans.factory.xml.ResourceEntityResolver - DTD/XSD XML entity http://www.springframework.org/schema/beans/spring-beans.xsd not found, falling back to remote https resolution". Исправлен заголовок файла beans.xml.

````shell
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">
````

Исправление ошибки: 
An exception occured while executing the Java class. Line 15 in XML document from class path resource [beans.xml] is invalid: Attribute "xmlns" must be declared for element type "beans".

Удален заголовок "<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">"

