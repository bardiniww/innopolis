package ru.innopolis.university.homework.lesson02.task03;

interface Sorter {

    void sort(Person[] persons);

    default void swap(Person[] persons, int a, int b) {
        Person temp = persons[a];
        persons[a] = persons[b];
        persons[b] = temp;
    }
}
