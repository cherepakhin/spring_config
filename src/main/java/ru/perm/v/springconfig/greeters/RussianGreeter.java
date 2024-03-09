package ru.perm.v.springconfig.greeters;

public class RussianGreeter implements Greeter {
    public String sayHello() {
        return "Привет, " + System.getProperty("user.name");
    }
}
