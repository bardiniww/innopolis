package ru.innopolis.university.homework.lesson04.task03;

import java.util.stream.Collectors;

class MathBox extends ObjectBox {

    public <T extends Number> MathBox(T[] numbers) {
        super(numbers);
    }

    /**
     * Adds an item to the collection {@link #objects}.
     *
     * @param object is object to be added.
     * @return {@code true} if item were added.
     */
    public <T extends Number> boolean addObject(T object) {
        return objects.add(object);
    }

    /**
     * Removes element of collection {@link #objects} that equals the given item.
     *
     * @param object is object which returns {@code true} for elements to be removed.
     * @return {@code true} if any elements were removed.
     */
    public <T> boolean deleteObject(T object) {
        return objects.removeIf(obj -> obj.equals(object));
    }

    /**
     * Сalculates the sum of elements in the collection {@link #objects}.
     *
     * @return sum of collection items.
     */
    public Number summutator() {
        return objects.stream().mapToDouble(n -> ((Number)n).doubleValue()).sum();
    }

    /**
     * Divides each number in the collection {@link #objects}
     * by the specified as argument number.
     *
     * @param splitNumber object extends {@link Number} is number separator.
     */
    public <T extends Number> void splitter(final T splitNumber) {
        objects = objects.stream()
                .map(n -> ((Number)n).doubleValue() / splitNumber.doubleValue())
                .collect(Collectors.toSet());
    }
}
