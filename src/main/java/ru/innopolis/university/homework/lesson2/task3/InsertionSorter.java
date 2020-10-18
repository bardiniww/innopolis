package ru.innopolis.university.homework.lesson2.task3;

class InsertionSorter implements Sorter {

    @Override
    public void sort(final Person[] persons) {
        int in;
        int out;

        for (out = 1; out < persons.length; out++) {
            Person temp = persons[out];
            in = out;

            while (in > 0 && persons[in - 1].compareTo(temp) > 0) {
                persons[in] = persons[in - 1];
                --in;
            }
            persons[in] = temp;
        }
    }
}
