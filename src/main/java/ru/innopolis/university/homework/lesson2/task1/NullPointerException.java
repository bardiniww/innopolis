package ru.innopolis.university.homework.lesson2.task1;

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
