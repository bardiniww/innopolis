package ru.innopolis.university.homework.lesson04.task02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ObjectBox {

    private Set<? super Object> objects;

    public ObjectBox(Object[] objects) {
        this.objects = new HashSet<>(Arrays.asList(objects));
    }

    public Set<? super Object> getObjects() {
        return objects;
    }

    public <T> boolean addObject(T object) {
        return objects.add(object);
    }

    public <T> boolean deleteObject(T object) {
        return objects.removeIf(obj -> obj.equals(object));
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
}
