package ru.innopolis.university.homework.lesson04.task03;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ObjectBox {

    protected Set<Object> objects;

    public ObjectBox(Object[] objects) {
        this.objects = new HashSet<>(Arrays.asList(objects));
    }

    /**
     * Composes a string from all items in the collection {@link #objects}.
     *
     * @return string representation of all elements in the collection.
     */
    public String dump() {
        StringBuilder sb = new StringBuilder();
        objects.forEach(obj -> sb.append(obj).append("\t"));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ObjectBox objectBox = (ObjectBox) o;

        return new EqualsBuilder()
                .append(objects, objectBox.objects)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(objects)
                .toHashCode();
    }

    @Override
    public String toString() {
        return dump();
    }
}
