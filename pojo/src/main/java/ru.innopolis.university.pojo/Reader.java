package ru.innopolis.university.pojo;

import java.util.Collection;

public class Reader extends BaseUser {

    private static final long serialVersionUID = 4733467599730775203L;

    public Reader() {
        super();
        roles.add(Role.READER);
    }

    public Reader(String login, String name, int age, Collection<Role> roles) {
        super(login, name, age, roles);
        roles.add(Role.READER);
    }
}
