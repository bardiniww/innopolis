package ru.innopolis.university.homework.lesson2.task3;

import java.util.Arrays;

class TaskBoot {

    public static void main(String... args) {
        Person[] persons = PersonGenerator.generate(10);
        System.out.println("Original:");
        display(persons);

        System.out.println();

        System.out.println("Insertion sort:");
        process(persons, new InsertionSorter());

        System.out.println();

        System.out.println("Bubble sort:");
        process(persons, new BubbleSorter());
    }

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
