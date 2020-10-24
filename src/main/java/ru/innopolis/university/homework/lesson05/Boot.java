package ru.innopolis.university.homework.lesson05;

import com.github.javafaker.Faker;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Boot {

    public static void main(String[] args) {
        PetStorage storage = new PetStorage(Arrays.asList(PetGenerator.generate(10)));
        storage.add(PetGenerator.generate());
        storage.findByName("write here name to find");
        storage.edit(1, PetGenerator.generate());
        storage.printSort();
    }

    private static class PetGenerator {

        private static final Faker faker = new Faker();

        /**
         * Generates a new object of Pet with random name, weight, owner.
         *
         * @return generated new object of Pet.
         */
        public static Pet generate() {
            return new Pet(
                    buildRandomName(),
                    buildRandomWeight(),
                    buildRandomOwner()
            ) {
            };
        }

        /**
         * Generates an array of random pets.
         *
         * @param count of pets to generate.
         * @return array of random generated pets.
         */
        public static Pet[] generate(int count) {
            return IntStream.range(0, count).mapToObj(i -> generate()).toArray(Pet[]::new);
        }

        private static String buildRandomName() {
            return faker.name().firstName();
        }

        private static BigDecimal buildRandomWeight() {
            return BigDecimal.valueOf(faker.number().numberBetween(3, 33));
        }

        private static Person buildRandomOwner() {
            return new Person(
                    faker.name().fullName(),
                    faker.number().numberBetween(14, 99),
                    faker.bool().bool() ? Person.Sex.MAN : Person.Sex.WOMAN
            );
        }

        private PetGenerator() {
            //no-op
        }
    }
}
