package ru.innopolis.university.pojo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.innopolis.university.util.IdGenerator;

public class Comment {

    private static final long serialVersionUID = 4978014028879427757L;

    private final String id;

    private String text;

    public Comment(String text) {
        id = String.valueOf(IdGenerator.getId());
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        return new EqualsBuilder()
                .append(id, comment.id)
                .append(text, comment.text)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(text)
                .toHashCode();
    }
}
