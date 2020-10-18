package ru.innopolis.university.homework.lesson04.task01;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MathBox {

    private Set<? extends Number> numbers;

    public MathBox(Number[] numbers) {
        this.numbers = new HashSet<>(Arrays.asList(numbers));
    }

    public Set<? extends Number> getNumbers() {
        return numbers;
    }

    /**
     * Сalculates the sum of elements in the collection {@link #numbers}.
     *
     * @return sum of collection items.
     */
    public Number summutator() {
        return numbers.stream().map(Number::doubleValue)
                .reduce(0d, Double::sum);
    }

    /**
     * Divides each number in the collection {@link #numbers}
     * by the specified as argument number.
     *
     * @param splitNumber object extends {@link Number} is number separator
     * @param <T> type extends Number.
     */
    public <T extends Number> void splitter(final T splitNumber) {
        numbers = numbers.stream()
                .map(num -> num.doubleValue() / splitNumber.doubleValue())
                .collect(Collectors.toSet());
    }

    /**
     * Removes element of collection {@link #numbers} that equals the given item.
     *
     * @param target is integer which returns {@code true} for elements to be removed.
     * @return {@code true} if any elements were removed.
     */
    public boolean removeElementIfExist(final Integer target) {
        return numbers.removeIf(element ->
                element instanceof Integer && element.equals(target));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        MathBox mathBox = (MathBox) o;

        return new EqualsBuilder()
                .append(getNumbers(), mathBox.getNumbers())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getNumbers())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "numbers=" + numbers +
                '}';
    }
}
