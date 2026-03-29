package dsa.exercises.strings;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HasUniqueCharsTest {

    private final HasUniqueChars uniqueChars = new HasUniqueChars();

    @ParameterizedTest(name = "Run {index}: input={0}, expected={1}")
    @MethodSource("hasUniqueCharsTestCases")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testHasUniqueChars1(String input, boolean expected) {
        assertEquals(expected, uniqueChars.hasUniqueChars(input),
                "Failed for input: " + input);
    }

    @ParameterizedTest(name = "Run {index}: input={0}, expected={1}")
    @MethodSource("hasUniqueCharsTestCases")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testHasUniqueChars2(String input, boolean expected) {
        assertEquals(expected, uniqueChars.hasUniqueChars1(input),
                "Failed for input: " + input);
    }


    private static Stream<Arguments> hasUniqueCharsTestCases() {
        return Stream.of(
                Arguments.of("hello", false),
                Arguments.of("thank you", true),
                Arguments.of("", true),
                Arguments.of(" ", true)
        );
    }
}