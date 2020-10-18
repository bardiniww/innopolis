package ru.innopolis.university.homework.lesson2.task1;

class CustomException {

    /**
     * Lesson 2, task 1.
     *
     * @throws java.lang.StackOverflowError
     */
    public static void main(String... args) {
        req();
    }

    private static void req() {
        req();
    }
}
