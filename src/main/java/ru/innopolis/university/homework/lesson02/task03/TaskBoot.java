package ru.innopolis.university.homework.lesson02.task03;

import java.util.Arrays;

class TaskBoot {

    public static void main(String... args) {
        startPrint(100);
    }

    /**
     * Prints a description of original order of persons,
     * after insertion sort {@link InsertionSorter},
     * after bubble sort {@link BubbleSorter}.
     *
     * @param countOfPersons is count of persons to process.
     */
    private static void startPrint(int countOfPersons) {
        Person[] persons = PersonGenerator.generate(countOfPersons);
        System.out.println("Original:");
        display(persons);

        System.out.println();

        System.out.println("Insertion sort:");
        process(persons, new InsertionSorter());

        System.out.println();

        System.out.println("Bubble sort:");
        process(persons, new BubbleSorter());
    }

    /**
     * Provides to sort array of persons and calculate the time spent
     * on sorting in milliseconds.
     *
     * @param persons is array of random persons to sort.
     * @param sorter the sorter that will be used for sorting.
     */
    private static void process(Person[] persons, Sorter sorter) {
        Person[] array = Arrays.copyOf(persons, persons.length);

        long start;
        long end;

        start = System.nanoTime();
        sorter.sort(array);
        end = System.nanoTime();

        display(array);
        System.out.println("Sort took " + (end - start) + " milliseconds.");
    }

    private static void display(Person[] persons) {
        Arrays.stream(persons).forEach(System.out::println);
    }
}
