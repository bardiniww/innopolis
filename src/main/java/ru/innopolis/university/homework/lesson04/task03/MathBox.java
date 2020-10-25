package ru.innopolis.university.homework.lesson04.task03;

import java.util.stream.Collectors;

/**
 * @param <T1> is type allowed to keep in storage
 */
class MathBox<T1> extends ObjectBox<T1> {

    public <T extends T1> MathBox(T[] numbers) {
        super(numbers);
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
