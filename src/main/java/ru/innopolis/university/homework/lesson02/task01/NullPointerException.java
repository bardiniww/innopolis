package ru.innopolis.university.homework.lesson02.task01;

class NullPointerException {

    /**
     * Lesson 2, task 1.
     *
     * @throws java.lang.NullPointerException
     */
    public static void main(String... args) {
        Object fake = null;
        fake.toString();
    }
}
