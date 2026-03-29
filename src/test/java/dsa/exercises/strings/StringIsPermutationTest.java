package dsa.exercises.strings;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringIsPermutationTest {

    private final StringIsPermutation isPermutation = new StringIsPermutation();

    @ParameterizedTest(name = "Run {index}: input={0}, expected={1}")
    @MethodSource("stringIsPermutationTestCases")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testHasUniqueChars1(String input1, String input2, boolean expected) {
        assertEquals(expected, isPermutation.stringIsPermutation(input1, input2),
                "Failed for input: " + input1 + ", " + input2);
    }

    @ParameterizedTest(name = "Run {index}: input={0}, expected={1}")
    @MethodSource("stringSortTestCases")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testHasUniqueChars2(String input, String expected) {
        assertEquals(expected, isPermutation.sort(input),
                "Failed for input: " + input);
    }


    private static Stream<Arguments> stringIsPermutationTestCases() {
        return Stream.of(
                Arguments.of("hello", "ellohh", false),
                Arguments.of("thank you", "thank you", true),
                Arguments.of("abcd", "efgh", false),
                Arguments.of("1234", "4321", true)
        );
    }

    private static Stream<Arguments> stringSortTestCases() {
        return Stream.of(
                Arguments.of("hello", "ehllo"),
                Arguments.of("bcfa", "abcf"),
                Arguments.of("3a6j", "36aj")
        );
    }
}