package ru.innopolis.university.homework.lesson2.task1;

class ArrayIndexOutOfBoundsException {

    /**
     * Lesson 2, task 1.
     *
     * @throws java.lang.ArrayIndexOutOfBoundsException
     */
    public static void main(String... args) {
        int[] array = new int[0];
        System.out.println(array[1]);
    }
}
