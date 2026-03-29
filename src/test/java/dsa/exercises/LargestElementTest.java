package dsa.exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestElementTest {

    private final LargestElement largestElement = new LargestElement();

    @ParameterizedTest(name = "Run {index}: input={0}, expected={1}")
    @MethodSource("secondLargestTestCases")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testSecondLargestElement(int[] input, int expected) {
        assertEquals(expected, largestElement.secondLargestElement(input),
                "Failed for input: " + java.util.Arrays.toString(input));
    }

    @ParameterizedTest(name = "Run {index}: input={0}, expected={1}")
    @MethodSource("thirdLargestTestCases")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testThirdLargestElement(int[] input, int expected) {
        assertEquals(expected, largestElement.thirdLargestElement(input),
                "Failed for input: " + java.util.Arrays.toString(input));
    }

    private static Stream<Arguments> secondLargestTestCases() {
        return Stream.of(
                Arguments.of(new int[]{12, 35, 1, 10, 34, 1}, 12),
                Arguments.of(new int[]{10, 5, 10}, 5),
                Arguments.of(new int[]{10, 10, 10}, -1),
                Arguments.of(new int[]{5, 10}, 5),
                Arguments.of(new int[]{10}, -1),
                Arguments.of(new int[]{}, -1),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4)
        );
    }

    private static Stream<Arguments> thirdLargestTestCases() {
        return Stream.of(
                Arguments.of(new int[]{12, 35, 1, 10, 34, 1}, 12),
                Arguments.of(new int[]{10, 5, 1}, 1),
                Arguments.of(new int[]{10, 10, 10}, -1),
                Arguments.of(new int[]{5, 10}, -1),
                Arguments.of(new int[]{10}, -1),
                Arguments.of(new int[]{}, -1),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 3)
        );
    }
}