package ru.perm.v.springconfig.service;

import ru.perm.v.springconfig.greeters.Greeter;

public class GreeterService {
    private Greeter greeter;

    public void setGreeter(Greeter greeter) {
        this.greeter = greeter;
    }

    public String getHello() {
        return greeter.sayHello();
    }
}
