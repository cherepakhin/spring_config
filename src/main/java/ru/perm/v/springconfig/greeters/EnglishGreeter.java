package ru.perm.v.springconfig.greeters;

public class EnglishGreeter implements Greeter {

    public String sayHello() {
        return "Hello, " + System.getProperty("user.name");
    }
}
