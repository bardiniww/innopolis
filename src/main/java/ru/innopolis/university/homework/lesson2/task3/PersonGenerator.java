package ru.innopolis.university.homework.lesson2.task3;

import com.github.javafaker.Faker;

import java.util.stream.IntStream;

import static ru.innopolis.university.homework.lesson2.task3.Person.Sex;

class PersonGenerator {

    private static final Faker faker = new Faker();

    public static Person generate() {
        return new Person(
               buildRandomName(),
               buildRandomAge(),
               buildRandomSex()
        );
    }

    public static Person[] generate(int count) {
        return IntStream.range(0, count).mapToObj(i -> generate()).toArray(Person[]::new);
    }

    private static String buildRandomName() {
        return faker.name().fullName();
    }

    private static int buildRandomAge() {
        return faker.number().numberBetween(13, 99);
    }

    private static Sex buildRandomSex() {
        return faker.bool().bool() ? Sex.MAN : Sex.WOMAN;
    }

    private PersonGenerator() {
        //no-op
    }
}
