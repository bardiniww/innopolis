package ru.innopolis.university.pojo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Author extends BaseUser implements ArticleWriter {

    private static final long serialVersionUID = 7502510148815597455L;

    private final Set<Article> articles = new HashSet<>();

    public Author() {
        super();
        roles.add(Role.AUTHOR);
    }

    public Author(String login, String name, int age, Collection<Role> roles) {
        super(login, name, age, roles);
        roles.add(Role.AUTHOR);
    }

    public void write(Article article) {
        if (null != article) {
            //todo implement
            articles.add(article);
        }
    }
}
