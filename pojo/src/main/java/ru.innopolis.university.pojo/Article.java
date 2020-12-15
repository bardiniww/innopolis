package ru.innopolis.university.pojo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.innopolis.university.util.IdGenerator;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Article {

    private static final long serialVersionUID = 2316738762559340864L;

    private final String id;

    private final BaseUser author;

    private final LocalDateTime creationDate;

    private final List<Comment> comments = new LinkedList<>();

    private String name;

    private String text;

    public Article(String name, BaseUser author, String text) {
        id = String.valueOf(IdGenerator.getId());
        creationDate = LocalDateTime.now();
        this.name = name;
        this.author = author;
        this.text = text;
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

    public BaseUser getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        if (null != comment) {
            comments.add(comment);
        }
    }

    public boolean removeComment(String id) {
        Comment target = comments.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (null != target) {
            return comments.remove(target);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        return new EqualsBuilder()
                .append(id, article.id)
                .append(author, article.author)
                .append(name, article.name)
                .append(text, article.text)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(author)
                .append(name)
                .append(text)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Article{" +
                "author=" + author +
                ", name='" + name + '\'' +
                '}';
    }
}
