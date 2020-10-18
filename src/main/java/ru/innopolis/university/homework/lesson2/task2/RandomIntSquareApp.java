package ru.innopolis.university.homework.lesson2.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

class RandomIntSquareApp {

    private static final Pattern YES =
            Pattern.compile(".*(?:да|давай|д|yes|y|sure).*",
                    Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);

    public static void main(String... args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            start(reader);
        }
    }

    /**
     * Reads data from standard input and runs the handler method for entered numbers.
     *
     * @param reader to read input values.
     * @throws IOException in case of input errors.
     * @throws IllegalArgumentException if any of entered values is not integer.
     * @throws IllegalArgumentException if any of entered values is negative.
     */
    private static void start(final BufferedReader reader) throws IOException, IllegalArgumentException {
        System.out.println("Enter the number of counts.");
        String numbersAmount = reader.readLine();

        if (isParsableAsInteger(numbersAmount)) {
            System.out.println("\nUse only positive values? (y/n)");
            final boolean useOnlyPositiveValues = YES.matcher(reader.readLine()).matches();
            final List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < Integer.parseInt(numbersAmount); i++) {
                numbers.add(ThreadLocalRandom.current().nextInt(
                        useOnlyPositiveValues ? 0 : Integer.MIN_VALUE, Integer.MAX_VALUE));
            }
            System.out.println("\nSelected numbers:");
            numbers.forEach(System.out::println);
            process(numbers);
            return;
        }

        throw new IllegalArgumentException("Invalid value of the numbers amount. Try again.");
    }

    /**
     * Check if the number is an integer.
     *
     * @param value to check
     * @return true if string value is an integer, false if not.
     */
    private static boolean isParsableAsInteger(final String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * For each number k, calculate the square root of q.
     * If the square of the integer part of q is equal to k,
     * then display this number on the screen.
     *
     * @param numbers the list of integers to process.
     * @throws IllegalArgumentException (optional) if any of argument numbers is negative.
     */
    private static void process(final List<Integer> numbers) throws IllegalArgumentException {

        System.out.println("\nResult:");

        if (numbers.stream().anyMatch(num -> num < 0)) {
            throw new IllegalArgumentException("Negative number is not allowed.");
        }

        final AtomicBoolean nothingPrinted = new AtomicBoolean(true);
        numbers.forEach(num -> {
            int squareRoot = (int) Math.sqrt(num);
            int squareOfSquareRoot = (int) Math.pow(squareRoot, 2);
            if (squareOfSquareRoot == num) {
                System.out.println(num);
                nothingPrinted.set(false);
            }
        });

        if (nothingPrinted.get()) {
            System.out.println("No matches found :(");
        }
    }
}
