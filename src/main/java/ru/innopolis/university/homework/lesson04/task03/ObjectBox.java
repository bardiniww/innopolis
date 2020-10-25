package ru.innopolis.university.homework.lesson04.task03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ObjectBox <T1> {

    protected Set<? super T1> objects;

    public ObjectBox(T1[] objects) {
        this.objects = new HashSet<>(Arrays.asList(objects));
    }

    public <T extends T1> boolean addObject(T object, Class<?> clazz) {
        if (object.getClass().equals(clazz)) {
            throw new IllegalArgumentException("class " + object.getClass() + "is not allowed to add.");
        }
        return objects.add(object);
    }

    public <T extends T1> boolean deleteObject(T object) {
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
