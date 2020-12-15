package ru.innopolis.university.pojo;

import ru.innopolis.university.util.IdGenerator;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Blog implements Serializable {

    private static final long serialVersionUID = 1591135739035534927L;

    private final String id;

    private String name;

    private Set<Article> articles = new HashSet<>();

    public Blog(String name) {
        id =  String.valueOf(IdGenerator.getId());
        name = name != null ? name : "not defined";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
