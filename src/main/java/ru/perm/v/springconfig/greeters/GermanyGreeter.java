package ru.perm.v.springconfig.greeters;

public class GermanyGreeter implements Greeter {

    public String sayHello() {
        return "Guten Tag, " + System.getProperty("user.name");
    }
}
