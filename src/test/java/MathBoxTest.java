import org.junit.Before;
import org.junit.Test;
import ru.innopolis.university.homework.lesson04.task01.MathBox;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class MathBoxTest {

    private static MathBox mathBox;

    @Before
    public void setUp() {
        mathBox = new MathBox(initialize(5));
    }

    @Test
    public void summutatorTest() {
        assertEquals("summutator failed",10D, mathBox.summutator());
    }

    @Test
    public void splitterTest() {
        Number[] testArray = initialize(5);

        int splitter = 5;

        IntStream.range(0, testArray.length)
                .forEach(i -> testArray[i] = testArray[i].doubleValue() / splitter);
        MathBox testMathBox = new MathBox(testArray);
        mathBox.splitter(splitter);

        assertEquals("splitter failed", testMathBox.getNumbers(), mathBox.getNumbers());
    }

    @Test
    public void removeElementIfExistTest() {
        int itemExist = 3;
        assertTrue(mathBox.getNumbers().contains(itemExist));
        mathBox.removeElementIfExist(itemExist);
        assertFalse(mathBox.getNumbers().contains(itemExist));

        int itemAbsent = 10;
        assertFalse(mathBox.getNumbers().contains(itemAbsent));
        assertFalse(mathBox.removeElementIfExist(itemAbsent));
    }

    private static Number[] initialize(int arrayLength) {
        Number[] numbers = new Number[5];
        IntStream.range(0, arrayLength).forEach(i -> numbers[i] = i);
        return numbers;
    }
}
