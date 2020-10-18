package ru.innopolis.university.homework.lesson2.task3;

class BubbleSorter implements Sorter{

    @Override
    public void sort(Person[] persons) {
        int in;
        int out;

        for (out = persons.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (persons[in].compareTo(persons[in + 1]) > 0) {
                    swap(persons, in, in + 1);
                }
            }
        }
    }
}
